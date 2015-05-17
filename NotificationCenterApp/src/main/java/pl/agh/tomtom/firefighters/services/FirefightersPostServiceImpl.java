package pl.agh.tomtom.firefighters.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.agh.tomtom.firefighters.assemblers.FirefightersPostAssembler;
import pl.agh.tomtom.firefighters.dao.FirefightersPostDAO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.dto.PostEquipmentInfo;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.model.FirefightersPost;

@Transactional(propagation = Propagation.REQUIRED)
public class FirefightersPostServiceImpl implements FirefightersPostService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("firefightersPostDAO")
	private FirefightersPostDAO firefightersPostDAO;

	@Override
	public void saveFirefightersPost(FirefightersPostDTO postDTO) throws FireException {
		log.entry(postDTO);

		Long id = postDTO.getId();
		FirefightersPost postModel = null;
		if (id != null) {
			postModel = firefightersPostDAO.get(id);
			if (postModel == null) {
				throw new FireException("Firefighters post with id=[" + id + "] not found");
			}
		} else {
			postModel = new FirefightersPost();
		}

		FirefightersPostAssembler.fillModelWithDTO(postModel, postDTO);

		firefightersPostDAO.saveOrUpdate(postModel);

		log.exit();
	}

	@Override
	public List<FirefightersPostDTO> getAllFirefightersPosts() {
		log.entry();

		List<FirefightersPost> postsInDB = firefightersPostDAO.list();
		List<FirefightersPostDTO> posts = postsInDB.stream()//
				.map(s -> FirefightersPostAssembler.fromModel(s))//
				.collect(Collectors.toList());

		log.exit(posts);
		return posts;
	}

	@Override
	public FirefightersPostCurrentDetailsDTO getCurrentDetails(Long id) throws FireException {
		log.entry();

		FirefightersPostDTO firefightersPostDTO = get(id);

		FirefightersPostCurrentDetailsDTO details = new FirefightersPostCurrentDetailsDTO();
		details.setFirefightersPost(firefightersPostDTO);

		// FIXME: connect to fire station post and get data, remove below
		details.setAvailable(true).setAvailableUnits(2);

		List<PostEquipmentInfo> availableEqipment = new ArrayList<PostEquipmentInfo>();
		availableEqipment.add(new PostEquipmentInfo().setEquipmentName("drabina").setCount(3));
		availableEqipment.add(new PostEquipmentInfo().setEquipmentName("helikopter").setCount(1));
		availableEqipment.add(new PostEquipmentInfo().setEquipmentName("pompa glebinowa").setCount(1));
		details.setEquipmentInfo(availableEqipment);

		log.exit(details);
		return details;
	}

	@Override
	public FirefightersPostDTO get(Long id) throws FireException {
		log.entry();

		FirefightersPost firefightersPost = firefightersPostDAO.get(id);
		if (firefightersPost == null) {
			throw new FireException("Post with id=[" + id + "] not found");
		}

		FirefightersPostDTO dto = FirefightersPostAssembler.fromModel(firefightersPost);

		log.exit(dto);
		return dto;
	}

}

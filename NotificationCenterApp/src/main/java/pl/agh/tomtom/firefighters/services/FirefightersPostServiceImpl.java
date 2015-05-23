package pl.agh.tomtom.firefighters.services;

import generated.integracja.common.dto.CurrentStateIDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.agh.tomtom.firefighters.assemblers.FirefightersPostAssembler;
import pl.agh.tomtom.firefighters.assemblers.FirefightersPostCurrentDetailsAssebler;
import pl.agh.tomtom.firefighters.dao.FirefightersPostDAO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.model.FirefightersPost;
import pl.agh.tomtom.firefighters.remote.FirefightersPostDownloader;

@Transactional(propagation = Propagation.REQUIRED)
public class FirefightersPostServiceImpl implements FirefightersPostService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("firefightersPostDAO")
	private FirefightersPostDAO firefightersPostDAO;

	@Autowired
	@Qualifier("firefightersPostDownloader")
	private FirefightersPostDownloader firefightersPostDownloader;

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

		CurrentStateIDTO details = firefightersPostDownloader.getCurrentState(firefightersPostDTO.getSystemIpAddress());
		FirefightersPostCurrentDetailsDTO detailsDTO = FirefightersPostCurrentDetailsAssebler.fromRemote(details,
				firefightersPostDTO);

		log.exit(detailsDTO);
		return detailsDTO;
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

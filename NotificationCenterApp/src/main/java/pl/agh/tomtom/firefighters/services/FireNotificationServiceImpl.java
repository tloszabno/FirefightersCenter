package pl.agh.tomtom.firefighters.services;

import generated.integracja.common.dto.FireNotificationIDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.tomtom.firefighters.assemblers.FireNotificationAssembler;
import pl.agh.tomtom.firefighters.assemblers.FireNotificationRemoteAssembler;
import pl.agh.tomtom.firefighters.dao.FireNotificationDAO;
import pl.agh.tomtom.firefighters.dao.FirefightersPostDAO;
import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.model.FireNotification;
import pl.agh.tomtom.firefighters.model.FirefightersPost;
import pl.agh.tomtom.firefighters.remote.FireNotificationNotifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(propagation = Propagation.REQUIRED)
public class FireNotificationServiceImpl implements FireNotificationService {
  private static final Logger log = LogManager.getLogger();

  @Autowired
  private FireNotificationDAO fireNotificationDAO;

  @Autowired
  private FirefightersPostDAO firefightersPostDAO;

  @Autowired
  private FireNotificationNotifier fireNotificationNotifier;

  @Override
  public void saveFireNotification(FireNotificationDTO notificationDTO) throws FireException {
    log.entry(notificationDTO);

    Long id = notificationDTO.getId();
    FireNotification fireNotification = resolveNewOrExistiongNotification(id);

    FireNotificationAssembler.fillModelWithDTO(fireNotification, notificationDTO);

    appendPosts(notificationDTO, fireNotification);

    fireNotificationDAO.saveOrUpdate(fireNotification);

    sentNotifications(notificationDTO);

    log.exit();
  }

  private FireNotification resolveNewOrExistiongNotification(Long id) throws FireException {
    FireNotification fireNotification;
    if (id != null) {
      fireNotification = fireNotificationDAO.get(id);
      if (fireNotification == null) {
        throw new FireException("Notification with id=[" + id + "] not found");
      }
    } else {
      fireNotification = new FireNotification();
    }
    return fireNotification;
  }

  private void sentNotifications(FireNotificationDTO notificationDTO) throws FireException {
    for (FirefightersPostDTO post : notificationDTO.getFirefightersPosts()) {
      FireNotificationIDTO idto = FireNotificationRemoteAssembler.toRemote(notificationDTO);

      this.fireNotificationNotifier.sendNotification(idto, post.getSystemIpAddress());
    }
  }

  private void appendPosts(FireNotificationDTO notificationDTO, FireNotification fireNotification) {
    List<FirefightersPost> firefightersPostsModel = new ArrayList<FirefightersPost>();
    for (FirefightersPostDTO postDTO : notificationDTO.getFirefightersPosts()) {
      Long postId = postDTO.getId();
      FirefightersPost model = firefightersPostDAO.get(postId);
      firefightersPostsModel.add(model);
    }
    fireNotification.setFirefightersPosts(firefightersPostsModel);
  }

  @Override
  public List<FireNotificationDTO> getAllNotifications() {
    log.entry();

    List<FireNotification> notifications = fireNotificationDAO.list();
    List<FireNotificationDTO> dtos = notifications.stream().map(s -> FireNotificationAssembler.fromModel(s))
        .collect(Collectors.toList());

    log.exit(dtos);
    return dtos;
  }

  @Override
  public FireNotificationDTO get(Long id) throws FireException {
    log.entry(id);

    FireNotification fireNotification = fireNotificationDAO.get(id);
    if (fireNotification == null) {
      throw new FireException("Fire Notification with id=[" + id + "] not found");
    }
    FireNotificationDTO dto = FireNotificationAssembler.fromModel(fireNotification);

    log.exit(dto);
    return dto;
  }

  @Override
  public void updateStateOfFireNotification(Long id, String newState) throws FireException {
    log.entry(id);

    FireNotification fireNotification = fireNotificationDAO.get(id);
    if (fireNotification == null) {
      throw new FireException("Fire Notification with id=[" + id + "] not found");
    }
    fireNotification.setActionState(newState);
    fireNotificationDAO.saveOrUpdate(fireNotification);

    log.exit();
  }
}

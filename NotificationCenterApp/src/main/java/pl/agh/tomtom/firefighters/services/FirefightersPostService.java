package pl.agh.tomtom.firefighters.services;

import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

import java.util.List;

public interface FirefightersPostService {
  void saveFirefightersPost(FirefightersPostDTO post) throws FireException;

  List<FirefightersPostDTO> getAllFirefightersPosts();

  FirefightersPostCurrentDetailsDTO getCurrentDetails(Long id) throws FireException;

  FirefightersPostDTO get(Long id) throws FireException;

  FirefightersPostDTO getByName(String postName) throws FireException;
}

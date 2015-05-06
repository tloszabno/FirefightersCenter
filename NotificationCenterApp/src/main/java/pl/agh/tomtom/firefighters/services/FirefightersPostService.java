package pl.agh.tomtom.firefighters.services;

import java.util.List;

import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FirefightersPostService {
	public void saveFirefightersPost(FirefightersPostDTO post) throws FireException;

	public List<FirefightersPostDTO> getAllFirefightersPosts();

	public FirefightersPostCurrentDetailsDTO getCurrentDetails(Long id) throws FireException;

	public FirefightersPostDTO get(Long id) throws FireException;
}

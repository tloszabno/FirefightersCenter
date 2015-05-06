package pl.agh.tomtom.firefighters.services;

import java.util.List;

import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FirefightersPostService {
	public void saveFirefightersPost(FirefightersPostDTO post) throws FireException;

	public List<FirefightersPostDTO> getAllFirefightersPosts();
}

package pl.agh.tomtom.firefighters.dto;

public class FirefightersPostCurrentDetailsDTO {
	private FirefightersPostDTO firefightersPost;
	private boolean available = false;
	private Integer availableUnits;

	public FirefightersPostCurrentDetailsDTO setAvailable(boolean available) {
		this.available = available;
		return this;
	}

	public FirefightersPostCurrentDetailsDTO setAvailableUnits(Integer availableUnits) {
		this.availableUnits = availableUnits;
		return this;
	}

	public FirefightersPostCurrentDetailsDTO setFirefightersPost(FirefightersPostDTO firefightersPost) {
		this.firefightersPost = firefightersPost;
		return this;
	}

	public Integer getAvailableUnits() {
		return availableUnits;
	}

	public FirefightersPostDTO getFirefightersPost() {
		return firefightersPost;
	}

	public boolean isAvailable() {
		return available;
	}

}

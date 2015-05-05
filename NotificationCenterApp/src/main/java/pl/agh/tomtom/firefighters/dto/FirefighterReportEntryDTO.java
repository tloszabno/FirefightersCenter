package pl.agh.tomtom.firefighters.dto;

public class FirefighterReportEntryDTO {
	private Long id;

	private String firstName;

	private String surname;

	public Long getId() {
		return id;
	}

	public FirefighterReportEntryDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public FirefighterReportEntryDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public FirefighterReportEntryDTO setSurname(String surname) {
		this.surname = surname;
		return this;
	}

}

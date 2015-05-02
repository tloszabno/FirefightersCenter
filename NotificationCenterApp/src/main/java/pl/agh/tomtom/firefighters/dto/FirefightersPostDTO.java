package pl.agh.tomtom.firefighters.dto;

public class FirefightersPostDTO {
	private Long id;

	private String name;

	private String address;

	private String city;

	private String community;

	private String systemIpAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getSystemIpAddress() {
		return systemIpAddress;
	}

	public void setSystemIpAddress(String systemIpAddress) {
		this.systemIpAddress = systemIpAddress;
	}

}

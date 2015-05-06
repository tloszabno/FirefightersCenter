package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "firefighters_post")
public class FirefightersPost implements Serializable {

	private static final long serialVersionUID = 1526428314059546208L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", length = 300, nullable = false)
	private String name;

	@Column(name = "address", length = 500, nullable = false)
	private String address;

	@Column(name = "city", length = 300, nullable = false)
	private String city;

	@Column(name = "community", length = 300, nullable = false)
	private String community;

	@Column(name = "system_ip_address", length = 100, nullable = false)
	private String systemIpAddress;

	public FirefightersPost() {
	}

	public Long getId() {
		return id;
	}

	public FirefightersPost setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public FirefightersPost setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public FirefightersPost setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public FirefightersPost setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCommunity() {
		return community;
	}

	public FirefightersPost setCommunity(String community) {
		this.community = community;
		return this;
	}

	public String getSystemIpAddress() {
		return systemIpAddress;
	}

	public FirefightersPost setSystemIpAddress(String systemIpAddress) {
		this.systemIpAddress = systemIpAddress;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

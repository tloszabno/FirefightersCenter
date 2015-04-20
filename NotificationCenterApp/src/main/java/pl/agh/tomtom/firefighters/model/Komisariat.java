package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "Komisariaty")
public class Komisariat implements Serializable {

	private static final long serialVersionUID = 1526428314059546208L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", length = 300, nullable = false)
	private String nazwa;

	@Column(name = "adres", length = 500, nullable = false)
	private String adres;

	@Column(name = "miasto", length = 300, nullable = false)
	private String miasto;

	@Column(name = "ip_systemu", length = 100, nullable = false)
	private String ipSystemu;

	public Komisariat() {
	}

	public Komisariat(Long id, String nazwa, String adres, String miasto,
			String ipSystemu) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.adres = adres;
		this.miasto = miasto;
		this.ipSystemu = ipSystemu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getIpSystemu() {
		return ipSystemu;
	}

	public void setIpSystemu(String ipSystemu) {
		this.ipSystemu = ipSystemu;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

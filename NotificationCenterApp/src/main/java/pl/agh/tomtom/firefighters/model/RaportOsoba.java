package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "raporty_osoby")
public class RaportOsoba implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "imie", length = 300, nullable = false)
	private String imie;

	@Column(name = "nazwisko", length = 300, nullable = false)
	private String nazwisko;

	public RaportOsoba() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

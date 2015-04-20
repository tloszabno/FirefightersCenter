package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "raporty_sprzet")
public class RaportSprzet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "rodzaj_sprzetu", nullable = false, length = 300)
	private String rodzajSprzetu;

	@Column(name = "czas_pracy_h", nullable = true)
	private Double czasPracyH;

	@Column(name = "rodzaj_paliwa", nullable = false, length = 300)
	private String rodzajPaliwa;

	public RaportSprzet() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRodzajSprzetu() {
		return rodzajSprzetu;
	}

	public void setRodzajSprzetu(String rodzajSprzetu) {
		this.rodzajSprzetu = rodzajSprzetu;
	}

	public Double getCzasPracyH() {
		return czasPracyH;
	}

	public void setCzasPracyH(Double czasPracyH) {
		this.czasPracyH = czasPracyH;
	}

	public String getRodzajPaliwa() {
		return rodzajPaliwa;
	}

	public void setRodzajPaliwa(String rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

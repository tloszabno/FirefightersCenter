package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "raporty_zastepy")
public class RaportZastep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "nazwa", length = 500, nullable = false)
	private String nazwa;

	@Column(name = "ilosc_osob", nullable = false)
	private Integer iloscOsob;

	@Column(name = "ilosc_przejechanych_km", nullable = true)
	private Integer iloscPrzejechanychKm;

	@Column(name = "czas_wyjazdu", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date czasWyjazdu;

	@Column(name = "czas_powrotu", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date czasPowrotu;

	@Column(name = "czas_pracy_pompy", nullable = true)
	private Integer czasPracyPompy;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_raporty_zastepu")
	private List<RaportSrodekGasniczy> srodkiGasnicze;

	public RaportZastep() {
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

	public Integer getIloscOsob() {
		return iloscOsob;
	}

	public void setIloscOsob(Integer iloscOsob) {
		this.iloscOsob = iloscOsob;
	}

	public Integer getIloscPrzejechanychKm() {
		return iloscPrzejechanychKm;
	}

	public void setIloscPrzejechanychKm(Integer iloscPrzejechanychKm) {
		this.iloscPrzejechanychKm = iloscPrzejechanychKm;
	}

	public Date getCzasWyjazdu() {
		return czasWyjazdu;
	}

	public void setCzasWyjazdu(Date czasWyjazdu) {
		this.czasWyjazdu = czasWyjazdu;
	}

	public Date getCzasPowrotu() {
		return czasPowrotu;
	}

	public void setCzasPowrotu(Date czasPowrotu) {
		this.czasPowrotu = czasPowrotu;
	}

	public Integer getCzasPracyPompy() {
		return czasPracyPompy;
	}

	public void setCzasPracyPompy(Integer czasPracyPompy) {
		this.czasPracyPompy = czasPracyPompy;
	}

	public void setSrodkiGasnicze(List<RaportSrodekGasniczy> srodkiGasnicze) {
		this.srodkiGasnicze = srodkiGasnicze;
	}

	public List<RaportSrodekGasniczy> getSrodkiGasnicze() {
		return srodkiGasnicze;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

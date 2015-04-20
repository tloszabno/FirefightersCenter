package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "RAPORTY")
public class Raport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_zgloszenia")
	private Zgloszenie zgloszenie;

	@ManyToOne
	@JoinColumn(name = "id_komisariatu")
	private Komisariat komisariat;

	@Column(name = "rodzaj_zdarzenia", length = 300, nullable = false)
	private String rodzajZdarzenia;

	@Column(name = "gmina", length = 300, nullable = false)
	private String gmina;

	@Column(name = "wielkosc", nullable = true)
	private Double wielkosc;

	@Column(name = "obiekt", length = 500, nullable = true)
	private String obiekt;

	@Column(name = "wlasciciel", length = 500, nullable = true)
	private String wlasciciel;

	@Column(name = "inne_uszkodzenia", length = 1000, nullable = true)
	private String inneUszkodzenia;

	@Column(name = "autor", length = 300, nullable = false)
	private String autor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_raportu")
	private List<RaportSprzet> sprzet;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_raportu")
	private List<RaportOsoba> osoby;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_raportu")
	private List<RaportZastep> zastepy;

	public Raport() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Zgloszenie getZgloszenie() {
		return zgloszenie;
	}

	public void setZgloszenie(Zgloszenie zgloszenie) {
		this.zgloszenie = zgloszenie;
	}

	public Komisariat getKomisariat() {
		return komisariat;
	}

	public void setKomisariat(Komisariat komisariat) {
		this.komisariat = komisariat;
	}

	public String getRodzajZdarzenia() {
		return rodzajZdarzenia;
	}

	public void setRodzajZdarzenia(String rodzajZdarzenia) {
		this.rodzajZdarzenia = rodzajZdarzenia;
	}

	public String getGmina() {
		return gmina;
	}

	public void setGmina(String gmina) {
		this.gmina = gmina;
	}

	public Double getWielkosc() {
		return wielkosc;
	}

	public void setWielkosc(Double wielkosc) {
		this.wielkosc = wielkosc;
	}

	public String getObiekt() {
		return obiekt;
	}

	public void setObiekt(String obiekt) {
		this.obiekt = obiekt;
	}

	public String getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(String wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public String getInneUszkodzenia() {
		return inneUszkodzenia;
	}

	public void setInneUszkodzenia(String inneUszkodzenia) {
		this.inneUszkodzenia = inneUszkodzenia;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<RaportSprzet> getSprzet() {
		return sprzet;
	}

	public void setSprzet(List<RaportSprzet> sprzet) {
		this.sprzet = sprzet;
	}

	public List<RaportOsoba> getOsoby() {
		return osoby;
	}

	public void setOsoby(List<RaportOsoba> osoby) {
		this.osoby = osoby;
	}

	public List<RaportZastep> getZastepy() {
		return zastepy;
	}

	public void setZastepy(List<RaportZastep> zastepy) {
		this.zastepy = zastepy;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

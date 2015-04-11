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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Table(name = "Zgloszenia")
@Entity
public class Zgloszenie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "typ", length = 200, nullable = false)
	private String typ;

	@Column(name = "adres", length = 300, nullable = false)
	private String adres;

	@Column(name = "miasto", length = 300, nullable = false)
	private String miasto;

	@Column(name = "wsp_gps_x", nullable = true)
	private Double wspGpsX;

	@Column(name = "wsp_gps_y", nullable = true)
	private Double wspGpsY;

	@Column(name = "stan_akcji", length = 1000, nullable = true)
	private String stanAkcji;

	@Column(name = "opis", length = 3000, nullable = true)
	private String opis;

	@Column(name = "data_zgloszenia", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZgloszenia;

	@Column(name = "data_zakonczenia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZakonczenia;

	@Column(name = "autor", length = 200, nullable = false)
	private String autor;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "zgloszenia_komisariaty")
	private List<Komisariat> komisariaty;

	public Zgloszenie() {
	}

	public Zgloszenie(String typ, String adres, String miasto, String autor) {
		super();
		this.typ = typ;
		this.adres = adres;
		this.miasto = miasto;
		this.autor = autor;
		this.dataZgloszenia = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
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

	public Double getWspGpsX() {
		return wspGpsX;
	}

	public void setWspGpsX(Double wspGpsX) {
		this.wspGpsX = wspGpsX;
	}

	public Double getWspGpsY() {
		return wspGpsY;
	}

	public void setWspGpsY(Double wspGpsY) {
		this.wspGpsY = wspGpsY;
	}

	public String getStanAkcji() {
		return stanAkcji;
	}

	public void setStanAkcji(String stanAkcji) {
		this.stanAkcji = stanAkcji;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDataZgloszenia() {
		return dataZgloszenia;
	}

	public void setDataZgloszenia(Date dataZgloszenia) {
		this.dataZgloszenia = dataZgloszenia;
	}

	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

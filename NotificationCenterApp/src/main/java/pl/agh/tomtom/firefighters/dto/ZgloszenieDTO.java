package pl.agh.tomtom.firefighters.dto;

import java.util.Date;

public class ZgloszenieDTO {

	private Long id;

	private String typ;

	private String adres;

	private String miasto;

	private Double wspGpsX;

	private Double wspGpsY;

	private String stanAkcji;

	private String opis;

	private Date dataZgloszenia;

	private Date dataZakonczenia;

	private String autor;

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

}

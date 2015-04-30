package pl.agh.tomtom.firefighters.dto;

import java.util.Date;

public class FireNotificationDTO {

	private Long id;

	private String type;

	private String address;

	private String city;

	private Double gpsXCoordinate;

	private Double gpsYCoordinate;

	private String actionState;

	private String description;

	private Date notificationDate;

	private Date finishDate;

	private String creator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTyp() {
		return type;
	}

	public void setTyp(String typ) {
		this.type = typ;
	}

	public String getAdres() {
		return address;
	}

	public void setAdres(String adres) {
		this.address = adres;
	}

	public String getMiasto() {
		return city;
	}

	public void setMiasto(String miasto) {
		this.city = miasto;
	}

	public Double getWspGpsX() {
		return gpsXCoordinate;
	}

	public void setWspGpsX(Double wspGpsX) {
		this.gpsXCoordinate = wspGpsX;
	}

	public Double getWspGpsY() {
		return gpsYCoordinate;
	}

	public void setWspGpsY(Double wspGpsY) {
		this.gpsYCoordinate = wspGpsY;
	}

	public String getStanAkcji() {
		return actionState;
	}

	public void setStanAkcji(String stanAkcji) {
		this.actionState = stanAkcji;
	}

	public String getOpis() {
		return description;
	}

	public void setOpis(String opis) {
		this.description = opis;
	}

	public Date getDataZgloszenia() {
		return notificationDate;
	}

	public void setDataZgloszenia(Date dataZgloszenia) {
		this.notificationDate = dataZgloszenia;
	}

	public Date getDataZakonczenia() {
		return finishDate;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.finishDate = dataZakonczenia;
	}

	public String getAutor() {
		return creator;
	}

	public void setAutor(String autor) {
		this.creator = autor;
	}

}

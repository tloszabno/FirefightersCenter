package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "raporty_srodki_gasnicze")
public class RaportSrodekGasniczy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "zrodlo_tankowania", nullable = false, length = 300)
	private String zrodloTankowania;

	public RaportSrodekGasniczy() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZrodloTankowania() {
		return zrodloTankowania;
	}

	public void setZrodloTankowania(String zrodloTankowania) {
		this.zrodloTankowania = zrodloTankowania;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

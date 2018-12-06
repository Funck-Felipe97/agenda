package agenda.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import agenda.model.enuns.Dia;

@Entity
public class HorarioAtendimento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private Dia dia;

	@Temporal(TemporalType.TIME)
	private Date horaChegada;

	@Temporal(TemporalType.TIME)
	private Date horaSaida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	public String getDescricao() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		return dia.getDescricao() + " das " + sdf.format(horaChegada) + " até " + sdf.format(horaSaida.getTime()); 
	}

}

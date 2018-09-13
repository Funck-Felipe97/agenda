package agenda.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import agenda.model.enuns.Dia;

@Entity
public class HorarioAtendimento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private Dia dia;

	private LocalTime horaChegada;

	private LocalTime hotaSaida;

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

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public LocalTime getHotaSaida() {
		return hotaSaida;
	}

	public void setHotaSaida(LocalTime hotaSaida) {
		this.hotaSaida = hotaSaida;
	}

}

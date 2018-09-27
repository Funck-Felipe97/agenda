package agenda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private LocalTime horario;
	
	private LocalTime horarioFim;

	private LocalDate data;

	private boolean confirmado;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Funcionario funcionario;

	@ManyToOne
	private Servico servico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public LocalTime getHorarioFim() {
		return horarioFim;
	}
	
	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}

}

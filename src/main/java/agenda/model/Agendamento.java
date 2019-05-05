package agenda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import agenda.model.enuns.StatusAgendamento;

@NamedQueries({
	@NamedQuery(name = "agendamento.findByFuncionarioAndData", query = "SELECT a FROM Agendamento a WHERE a.funcionario = :funcionario AND a.data = :dataBusca")
})
@Entity
public class Agendamento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private HorarioAtendimento horarioAtendimento;

	private LocalDate data;

	private boolean confirmado;
	
	@Enumerated(EnumType.STRING)
	private StatusAgendamento statusAgendamento;

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

	public LocalDate getData() {
		if (data == null) {
			this.data = LocalDate.now();
		}
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
	
	public HorarioAtendimento getHorarioAtendimento() {
		return horarioAtendimento;
	}
	
	public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	
	public StatusAgendamento getStatusAgendamento() {
		return statusAgendamento;
	}
	
	public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

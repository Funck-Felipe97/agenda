package agenda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import agenda.model.enuns.Permissao;

@Entity
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@ManyToMany
	private List<Servico> servicos;

	@ManyToMany
	private List<HorarioAtendimento> horariosAtendimento;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Agendamento> agendamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Servico> getServicos() {
		if (servicos == null) {
			servicos = new ArrayList<>();
		}
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<HorarioAtendimento> getHorariosAtendimento() {
		if (horariosAtendimento == null) {
			horariosAtendimento = new ArrayList<>();
		}
		return horariosAtendimento;
	}

	public void setHorariosAtendimento(List<HorarioAtendimento> horariosAtendimento) {
		this.horariosAtendimento = horariosAtendimento;
	}
	
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

}

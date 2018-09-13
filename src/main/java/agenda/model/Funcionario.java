package agenda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "funcionarios")
	private List<Servico> servicos;

	@ManyToMany
	private List<HorarioAtendimento> horariosAtendimento;

	@Enumerated(EnumType.STRING)
	private Permissao permissao;

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
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<HorarioAtendimento> getHorariosAtendimento() {
		return horariosAtendimento;
	}

	public void setHorariosAtendimento(List<HorarioAtendimento> horariosAtendimento) {
		this.horariosAtendimento = horariosAtendimento;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

}

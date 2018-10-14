package agenda.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import agenda.model.enuns.Permissao;

@Entity
@NamedQueries({
	@NamedQuery(name="usuario.findByLogin", query="SELECT u FROM Usuario u WHERE u.login = :login")
})
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	private String login;
	private String senha;
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissao;

	
	
	public Usuario() {
		setAtivo(true);;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
}

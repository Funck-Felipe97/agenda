package agenda.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Funcionario;
import agenda.model.enuns.Permissao;
import agenda.service.FuncionarioService;

@ManagedBean
@SessionScoped
public class FuncionarioBean extends AbstractBean {

	private Funcionario funcionario;
	private FuncionarioService funcionarioService;
	private String confirmarSenha;

	public FuncionarioBean() {
		this.funcionario = new Funcionario();
		this.funcionarioService = new FuncionarioService();
	}

	public void save() {
		if (funcionario.getUsuario().getSenha().equals(confirmarSenha)) {
			try {
				funcionario.getUsuario().setPermissao(Permissao.ROLE_FUNCIONARIO);
				funcionarioService.save(this.funcionario);
				super.info("Funcionario cadastrado com sucesso");
				this.funcionario = new Funcionario();
			} catch (ObjetoJaCadastradoException e) {
				super.warn("Usuario já existente");
			} catch (Exception e) {
				super.error("Ocorreu uma falha");
			}
		} else {
			super.error("As senhas são diferentes");
		}

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		try {
			context.getExternalContext().redirect("../index.xhtml");
		} catch (IOException ex) {

		}
	}

}
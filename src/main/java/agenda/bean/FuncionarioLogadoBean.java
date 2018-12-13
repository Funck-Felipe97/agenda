package agenda.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import agenda.dao.FuncionarioDao;
import agenda.dao.UsuarioDao;
import agenda.model.Funcionario;
import agenda.model.Usuario;

@SessionScoped
@ManagedBean
public class FuncionarioLogadoBean extends AbstractBean{
	
	private Funcionario funcionario;
	private String confirmarSenha;

	public Funcionario getFuncionario() {
		Usuario usuario = new Usuario();
		usuario.setLogin(((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName());
		funcionario = new UsuarioDao().findByLogin(usuario.getLogin()).getFuncionario();
		return funcionario;
	}
	
	public void update() {
		if (this.funcionario.getUsuario().getSenha().equals(confirmarSenha)) {
			try {
				new FuncionarioDao().update(this.funcionario);
				super.info("Informações salvas com sucesso");
			} catch (Exception e) {
				super.error("Ocorreu uma falha ao salvar as informações");
			}
		} else {
			super.info("As senha são diferentes");
		}
	}
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
}

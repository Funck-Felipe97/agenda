package agenda.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import agenda.dao.UsuarioDao;
import agenda.model.Funcionario;
import agenda.model.Usuario;

@SessionScoped
@ManagedBean
public class FuncionarioLogadoBean {
	
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		Usuario usuario = new Usuario();
		usuario.setLogin(((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName());
		funcionario = new UsuarioDao().findByLogin(usuario.getLogin()).getFuncionario();
		return funcionario;
	}
	
}

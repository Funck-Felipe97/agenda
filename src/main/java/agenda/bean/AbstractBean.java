package agenda.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import agenda.dao.FuncionarioDao;
import agenda.dao.UsuarioDao;
import agenda.model.Funcionario;
import agenda.model.Usuario;

@ManagedBean
public abstract class AbstractBean {
	
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			Usuario usuario = new Usuario();
			usuario.setLogin(((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName());
			funcionario = new UsuarioDao().findByLogin(usuario.getLogin()).getFuncionario();
		}
		return funcionario;
	}
	
	public void atualizarFuncionario() {
		this.funcionario = new FuncionarioDao().findById(funcionario.getId());
	}
	
	public void info(String Validation) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", Validation));
    }
 
    public void warn(String Validation) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", Validation));
    }
 
    public void error(String Validation) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", Validation));
    }
 
    public void fatal(String Validation) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", Validation));
    }
}

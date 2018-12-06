package agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.Funcionario;
import agenda.service.FuncionarioService;

@ManagedBean
@SessionScoped
public class FuncionarioBean extends AbstractBean{

	private Funcionario funcionario;
	private FuncionarioService funcionarioService;
		
	public FuncionarioBean() {
		this.funcionario = new Funcionario();
		this.funcionarioService = new FuncionarioService();
	}
	
	public void save() {
		try {
			funcionarioService.save(this.funcionario);
			super.info("Funcionario cadastrado com sucesso");
			this.funcionario = new Funcionario();
		} catch(Exception e) {
			super.error("Ocorreu uma falha");
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
	
}
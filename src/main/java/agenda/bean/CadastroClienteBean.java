package agenda.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Cliente;
import agenda.model.Servico;
import agenda.model.enuns.Permissao;
import agenda.service.CadastroService;

@ManagedBean
@SessionScoped
public class CadastroClienteBean extends AbstractBean{
	
	private Cliente cliente;
	private CadastroService cadastroService;
	
	public CadastroClienteBean() {
		this.cadastroService = new CadastroService();
	}
	
	public void save(){
		try {
			this.cadastroService.save(cliente);
			this.cliente = new Cliente();
			super.info("Cliente Cadastrado com Sucesso!!");
		} catch (ObjetoJaCadastradoException e) {
			super.warn("Um cliente já está cadastrado para este login");
			e.printStackTrace();
		}
	}
	
	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}

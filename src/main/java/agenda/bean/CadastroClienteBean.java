package agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;

import agenda.converter.ClienteConverter;
import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Cliente;
import agenda.service.CadastroService;

@ManagedBean
@ViewScoped
public class CadastroClienteBean extends AbstractBean{
	
	private Cliente cliente;
	private CadastroService cadastroService;
	private List<Cliente> clientes;
	
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
	
	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = this.cadastroService.getAll();
		}
		return clientes;
	}
	
	public Converter getConverter() {
		return new ClienteConverter(clientes);
	}
	
}

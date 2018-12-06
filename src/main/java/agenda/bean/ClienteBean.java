package agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.Cliente;
import agenda.service.ClienteService;

@ManagedBean
@SessionScoped
public class ClienteBean extends AbstractBean{

	private Cliente cliente;
	private ClienteService clienteService;
	
	public ClienteBean() {
		this.clienteService = new ClienteService();
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
		return clienteService.getAll();
	}
	
}

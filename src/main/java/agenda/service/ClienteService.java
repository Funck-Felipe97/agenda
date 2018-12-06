package agenda.service;

import java.util.List;

import agenda.dao.ClienteDao;
import agenda.model.Cliente;

public class ClienteService {

	private ClienteDao clienteDao;
	
	public ClienteService() {
		this.clienteDao = new ClienteDao();
	}
	
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	public List<Cliente> getAll() {
		return clienteDao.findAll();
	}

}

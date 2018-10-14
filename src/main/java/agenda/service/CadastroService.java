package agenda.service;

import java.util.List;

import javax.persistence.NoResultException;

import agenda.dao.ClienteDao;
import agenda.dao.UsuarioDao;
import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Cliente;
import agenda.model.Usuario;

public class CadastroService {

	private ClienteDao clienteDao;

	public CadastroService() {
		this.clienteDao = new ClienteDao();
	}

	public Cliente save(Cliente cliente) throws ObjetoJaCadastradoException {
		Usuario usuario = null;
		try {
			usuario = new UsuarioDao().findByLogin(cliente.getUsuario().getLogin());
		} catch (NoResultException ex) {
		}

		if (usuario != null) {
			throw new ObjetoJaCadastradoException();
		}
		
		if (cliente.getId() != null) {
			return clienteDao.update(cliente);
		}
		
		return clienteDao.save(cliente);
	}

	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
	}

	public List<Cliente> getAll() {
		return clienteDao.findAll();
	}
}

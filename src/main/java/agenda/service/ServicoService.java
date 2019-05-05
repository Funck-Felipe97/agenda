package agenda.service;

import java.util.List;

import javax.persistence.NoResultException;

import agenda.dao.ServicoDao;
import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Servico;

public class ServicoService {

	private ServicoDao servicoDao;

	public ServicoService() {
		this.servicoDao = new ServicoDao();
	}

	public Servico save(Servico servico) throws ObjetoJaCadastradoException {
		Servico servicoAuxiliar = null;
		try {
			servicoAuxiliar = servicoDao.findByDescricao(servico.getDescricao());
		} catch (NoResultException e) {
			
		}
		
		if (servico.getId() != null) {
			if (servicoAuxiliar != null) {
				if (servicoAuxiliar.getDescricao().equals(servico.getDescricao()) 
						&& !servicoAuxiliar.getId().equals(servico.getId())) {
					throw new ObjetoJaCadastradoException();
				}
			}
			return servicoDao.update(servico);
		}
		
		if (servicoAuxiliar != null) {
			throw new ObjetoJaCadastradoException();
		}
		
		return servicoDao.save(servico);
	}

	public void delete(Servico servico) {
		servicoDao.delete(servico);
	}

	public List<Servico> getAll() {
		return servicoDao.findAll();
	}
}

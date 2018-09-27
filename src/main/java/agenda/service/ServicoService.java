package agenda.service;

import java.util.List;

import agenda.dao.ServicoDao;
import agenda.model.Servico;

public class ServicoService {

private ServicoDao servicoDao;
	
	public ServicoService() {
		this.servicoDao = new ServicoDao();
	}
	
	public Servico save(Servico servico) {
		if (servico.getId() != null) {
			return servicoDao.update(servico);
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

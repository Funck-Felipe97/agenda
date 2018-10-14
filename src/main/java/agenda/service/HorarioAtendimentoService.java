package agenda.service;

import java.util.List;

import agenda.dao.HorarioAtendimentoDao;
import agenda.model.HorarioAtendimento;

public class HorarioAtendimentoService {

	private HorarioAtendimentoDao horarioAtendimentoDao;
	
	public HorarioAtendimentoService() {
		this.horarioAtendimentoDao = new HorarioAtendimentoDao();
	}
	
	public List<HorarioAtendimento> getAll() {
		return this.horarioAtendimentoDao.findAll();
	}

	public void save(HorarioAtendimento horarioAtendimento) {
		this.horarioAtendimentoDao.save(horarioAtendimento);
	}

}

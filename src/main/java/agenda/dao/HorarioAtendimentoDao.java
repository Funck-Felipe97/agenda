package agenda.dao;

import java.util.List;

import agenda.model.HorarioAtendimento;

public class HorarioAtendimentoDao extends AbstractDao<HorarioAtendimento>{

	public HorarioAtendimentoDao() {
		super(HorarioAtendimento.class);
	}

	public List<HorarioAtendimento> findAllByFuncionario() {
		return null;
	}

}

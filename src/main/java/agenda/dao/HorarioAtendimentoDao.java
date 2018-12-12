package agenda.dao;

import java.time.LocalDate;
import java.util.List;

import agenda.bean.HorarioAtendimentoBean;
import agenda.model.Funcionario;
import agenda.model.HorarioAtendimento;

public class HorarioAtendimentoDao extends AbstractDao<HorarioAtendimento>{

	public HorarioAtendimentoDao() {
		super(HorarioAtendimento.class);
	}

	public List<HorarioAtendimento> findAllByFuncionario() {
		return null;
	}

}

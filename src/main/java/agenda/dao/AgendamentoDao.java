package agenda.dao;

import java.time.LocalDate;
import java.util.List;

import agenda.model.Agendamento;
import agenda.model.Funcionario;

public class AgendamentoDao extends AbstractDao<Agendamento>{

	public AgendamentoDao() {
		super(Agendamento.class);
	}

	public List<Agendamento> getAllByFuncionadoAndData(Funcionario funcionario, LocalDate dataBusca) {
		return super.createNamedQuery("agendamento.findByFuncionarioAndData")
				.setParameter("funcionario", funcionario)
				.setParameter("dataBusca", dataBusca)
				.getResultList();
	}

}

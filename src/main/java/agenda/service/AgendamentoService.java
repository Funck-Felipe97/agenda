package agenda.service;

import java.time.LocalDate;
import java.util.List;

import agenda.dao.AgendamentoDao;
import agenda.model.Agendamento;
import agenda.model.Funcionario;

public class AgendamentoService {

	private AgendamentoDao agendamentoDao;
	
	public AgendamentoService() {
		this.agendamentoDao = new AgendamentoDao();
	}

	public List<Agendamento> getAgendaFuncionario(Funcionario funcionario, LocalDate dataBusca) {
		return this.agendamentoDao.getAllByFuncionadoAndData(funcionario, dataBusca);
	}
	
}

package agenda.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.Agendamento;
import agenda.model.Funcionario;
import agenda.service.AgendamentoService;

@ManagedBean
@SessionScoped
public class AgendaFuncionarioBean {
	
	private LocalDate dataBusca;
	private AgendamentoService agendamentoService;
	private List<Agendamento> agendamentos;
	
	public AgendaFuncionarioBean() {
		this.agendamentoService = new AgendamentoService();
		this.dataBusca = LocalDate.now();
	}
	
	public LocalDate getDataBusca() {
		return dataBusca;
	}
	
	public void setDataBusca(LocalDate dataBusca) {
		this.dataBusca = dataBusca;
	}
	
	public List<Agendamento> getAgendamentos() {
		if (agendamentos == null) {
			agendamentos = new ArrayList<>();
		}
		System.out.println(agendamentos.size());
		return agendamentos;
	}
	
	public void buscarAgenda(Funcionario funcionario){
		this.agendamentos = agendamentoService.getAgendaFuncionario(funcionario, dataBusca);
	}
	
}

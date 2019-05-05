package agenda.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import agenda.model.Agendamento;
import agenda.model.Funcionario;
import agenda.model.enuns.StatusAgendamento;
import agenda.service.AgendamentoService;

@ManagedBean
@ViewScoped
public class AgendaFuncionarioBean extends AbstractBean{
	
	private LocalDate dataBusca;
	private AgendamentoService agendamentoService;
	private List<Agendamento> agendamentos;
	
	public AgendaFuncionarioBean() {
		this.agendamentoService = new AgendamentoService();
		this.dataBusca = LocalDate.now();
	}
	
	public void update(Agendamento agendamento) {
		try {
			this.agendamentoService.update(agendamento);
			super.info("Agendamento salvo com sucesso");
		} catch (Exception e) {
			super.error("Falha ao salvar");
		}
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
		return agendamentos;
	}
	
	public void buscarAgenda(Funcionario funcionario){
		this.agendamentos = agendamentoService.getAgendaFuncionario(funcionario, dataBusca);
		if (getAgendamentos().isEmpty()) {
			super.info("Nenhum agendamento encontrado");
		}
	}
	
	public List<StatusAgendamento> getStatus() {
		return Arrays.asList(StatusAgendamento.values());
	}
	
}

package agenda.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import agenda.model.Agendamento;
import agenda.model.Funcionario;
import agenda.model.HorarioAtendimento;
import agenda.model.Servico;
import agenda.model.enuns.Dia;
import agenda.model.enuns.StatusAgendamento;
import agenda.service.AgendamentoService;

@ManagedBean
@ViewScoped
public class AgendamentoBean extends AbstractBean {

	private List<Servico> servicos;
	private Agendamento agendamento;
	private AgendamentoService agendamentoService;
	
	public AgendamentoBean() {
		this.agendamentoService = new AgendamentoService();
		this.agendamento = new Agendamento();
		this.agendamento.setData(LocalDate.now());
		this.agendamento.setFuncionario(getFuncionario());
	}

	public List<HorarioAtendimento> getHorariosDisponiveis() {	
			List<Agendamento> agendamentos = getFuncionario().getAgendamentos();
			return this.getFuncionario()
					.getHorariosAtendimento()
					.stream()
					.filter(horario -> {
						if(horario.getDia().equals(Dia.getEnum(this.agendamento.getData()))){
							if (agendamentos.stream()
									.filter(agendamento->{
										boolean dataIgual = agendamento.getData().equals(this.agendamento.getData());
										boolean horarioIgual = agendamento.getHorarioAtendimento().equals(horario);
										boolean ativo = agendamento.getStatusAgendamento().equals(StatusAgendamento.AGENDADO);
										return (dataIgual && horarioIgual && ativo);
									}).findFirst().isPresent()){
								return false;
							}
							return true;
						}
						return false;
					}).collect(Collectors.toList());
		
	}

	public List<Servico> getServicos() {
		if (this.servicos == null) {
			this.servicos = new ArrayList<>();
		}
		return servicos;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public void save() {
		try {
			this.agendamento.setStatusAgendamento(StatusAgendamento.AGENDADO);
			this.agendamentoService.save(this.agendamento);
			super.info("Agendamento salvo com sucesso");
			this.agendamento = new Agendamento();
			this.agendamento.setData(LocalDate.now());
			super.atualizarFuncionario();
			this.agendamento.setFuncionario(getFuncionario());
		} catch (Exception e) {
			super.error("Falha ao salvar");
		}
	}
	
	

}

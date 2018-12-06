package agenda.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.Agendamento;
import agenda.model.Funcionario;
import agenda.model.Servico;
import agenda.service.AgendamentoService;

@ManagedBean
@SessionScoped
public class AgendamentoBean extends AbstractBean {

	private List<Servico> servicos;
	private List<HorarioAtendimentoBean> horariosDisponiveis;
	private List<Funcionario> funcionaios;
	private Agendamento agendamento;
	private AgendamentoService agendamentoService;
	
	public AgendamentoBean() {
		this.agendamentoService = new AgendamentoService();
		this.agendamento = new Agendamento();
	}
	
	public List<Funcionario> getFuncionaios() {
		if (funcionaios == null) {
			this.funcionaios = new ArrayList<>();
		}
		return funcionaios;
	}
	
	public List<HorarioAtendimentoBean> getHorariosDisponiveis() {
		if (horariosDisponiveis == null) {
			this.horariosDisponiveis = new ArrayList<>();
		}
		return horariosDisponiveis;
	}
	
	public List<Servico> getServicos() {
		if (this.servicos == null) {
			this.servicos = new ArrayList<>();
		}
		return servicos;
	}
	
}

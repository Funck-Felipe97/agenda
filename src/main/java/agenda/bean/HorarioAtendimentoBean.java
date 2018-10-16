package agenda.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.HorarioAtendimento;
import agenda.model.enuns.Dia;
import agenda.service.HorarioAtendimentoService;

@ManagedBean
@SessionScoped
public class HorarioAtendimentoBean {

	private HorarioAtendimento horarioAtendimento;
	private HorarioAtendimentoService horarioAtendimentoService;

	public HorarioAtendimentoBean() {
		this.horarioAtendimentoService = new HorarioAtendimentoService();
	}

	public HorarioAtendimento getHorarioAtendimento() {
		if (this.horarioAtendimento == null) {
			this.horarioAtendimento = new HorarioAtendimento();
		}
		return horarioAtendimento;
	}
	
	public void save() {
		this.horarioAtendimentoService.save(this.horarioAtendimento);
		this.horarioAtendimento = new HorarioAtendimento();
	}

	public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public List<HorarioAtendimento> getHorariosAtendimento() {
		return this.horarioAtendimentoService.getAll();
	}
	
	public List<Dia> getDias() {
		return Arrays.asList(Dia.values());
	}
}

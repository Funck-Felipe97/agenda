package agenda.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.Converter;

import agenda.converter.HorarioAtendimentoConverter;
import agenda.model.HorarioAtendimento;
import agenda.model.enuns.Dia;
import agenda.service.HorarioAtendimentoService;

@ManagedBean
@SessionScoped
public class HorarioAtendimentoBean extends AbstractBean{

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
		try {
			if (horarioAtendimento.getHoraChegada().after(horarioAtendimento.getHoraSaida())) {
				super.warn("O horário inicial não pode ser maior que o horário final");
				return;
			}
			this.horarioAtendimentoService.save(this.horarioAtendimento);
			this.horarioAtendimento = new HorarioAtendimento();
			super.info("Horário de atendimento salvo com sucesso");
		} catch (Exception e) {
			super.error("Falha ao salvar horário de atendimento");
		}
		
	}
	
	public void novo() {
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
	
	public Converter getConverter() {
		return new HorarioAtendimentoConverter(getHorariosAtendimento());
	}
}

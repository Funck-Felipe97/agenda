package agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import agenda.model.Servico;
import agenda.service.ServicoService;

@ManagedBean
@SessionScoped
public class ServicoBean {

	private Servico servico;
	private ServicoService servicoService;
	
	public ServicoBean() {
		this.servicoService = new ServicoService();
	}
	
	public void save() {
		this.servicoService.save(servico);
		this.servico = new Servico();
	}

	public Servico getServico() {
		if (servico == null) {
			servico = new Servico();
		}
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicoService.getAll();
	}

}

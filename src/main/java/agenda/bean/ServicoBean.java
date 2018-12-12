package agenda.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;

import agenda.converter.ServicoConverter;
import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Servico;
import agenda.service.ServicoService;

@ManagedBean
@ViewScoped
public class ServicoBean extends AbstractBean{

	private Servico servico;
	private ServicoService servicoService;
	
	public ServicoBean() {
		this.servicoService = new ServicoService();
	}
	
	public void save() {
		try {
			this.servicoService.save(servico);
			this.servico = new Servico();
			super.info("Serviço cadastrado com sucesso");
		} catch (ObjetoJaCadastradoException e) {
			super.warn("Este produto já foi cadastrado.");
			e.printStackTrace();
		}
		
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
	
	public Converter getServicoConverter() {
		return new ServicoConverter(getServicos());
	}
	
}

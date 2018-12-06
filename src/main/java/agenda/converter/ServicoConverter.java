package agenda.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import agenda.model.Servico;

@FacesConverter(forClass = Servico.class ,value = "servicoConverter")
public class ServicoConverter implements Converter{

	private List<Servico> servicos;
	
	public ServicoConverter(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return servicos.stream().filter(s->s.getDescricao().equals(value)).findFirst().get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Servico) {
			return ((Servico) value).getDescricao();
		}
		return "";
	}

}

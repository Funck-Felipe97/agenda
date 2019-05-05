package agenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import agenda.model.enuns.StatusAgendamento;

@FacesConverter(forClass = StatusAgendamento.class, value = "statusAgendamentoConverter")
public class StatusAgendamentoConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		StatusAgendamento retorno = null;
		if (value != null) {
			if (!value.isEmpty()) {
				retorno = StatusAgendamento.valueOf(value.toUpperCase());
			}
		}
		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String retorno = "";
		if (value != null) {
			if (value instanceof StatusAgendamento) {
				retorno  = ((StatusAgendamento) value).getDescricao();
			}
		}
		return retorno;
	}

	
}

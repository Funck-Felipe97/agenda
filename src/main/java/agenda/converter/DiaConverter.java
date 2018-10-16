package agenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import agenda.model.enuns.Dia;

@FacesConverter(forClass = Dia.class, value = "diaConverter")
public class DiaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Dia retorno = null;
		if (value != null) {
			if (!value.isEmpty()) {
				retorno = Dia.getEnum(value);
			}
		}
		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String retorno = "";
		if (value != null) {
			if (value instanceof Dia) {
				retorno  = ((Dia) value).getDescricao();
			}
		}
		return retorno;
	}

}

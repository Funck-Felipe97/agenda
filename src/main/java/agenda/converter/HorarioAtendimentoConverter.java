package agenda.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import agenda.model.HorarioAtendimento;

@FacesConverter(forClass = HorarioAtendimento.class , value = "horarioAtendimentoConverter")
public class HorarioAtendimentoConverter implements Converter{

	private List<HorarioAtendimento> horariosAtendimento;
	
	public HorarioAtendimentoConverter(List<HorarioAtendimento> horariosAtendimento) {
		this.horariosAtendimento = horariosAtendimento;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println(value);
		return this.horariosAtendimento.stream().filter(item -> item.getDescricao().equals(value)).findFirst().get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String retorno = "";
		if (value instanceof HorarioAtendimento) {
			if (value != null) {
				retorno = ((HorarioAtendimento) value).getDescricao();
			}
		}
		return retorno;
	}

}

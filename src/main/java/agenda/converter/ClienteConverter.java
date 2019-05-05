package agenda.converter;

import java.util.List;
import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import agenda.model.Cliente;

@FacesConverter(forClass = Cliente.class, value = "clienteConverter")
public class ClienteConverter implements Converter {
	
	private List<Cliente> clientes;
	
	public ClienteConverter(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Optional<Cliente> cliente =  this.clientes.stream().filter(c -> c.getNome().equals(value)).findAny();
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String retorno = "";
		if (value != null) {
			if (value instanceof Cliente) {
				retorno = ((Cliente) value).getNome();
			}
		}
		return retorno;
	}

}

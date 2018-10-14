package agenda.exceptions;

public class ObjetoJaCadastradoException extends Exception{
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Objeto já cadastrado";
	}
}

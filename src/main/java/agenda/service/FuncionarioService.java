package agenda.service;

import javax.persistence.NoResultException;

import agenda.dao.FuncionarioDao;
import agenda.dao.UsuarioDao;
import agenda.exceptions.ObjetoJaCadastradoException;
import agenda.model.Funcionario;
import agenda.model.Usuario;

public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService() {
		this.funcionarioDao =  new FuncionarioDao();
	}
	
	public void save(Funcionario funcionario) throws ObjetoJaCadastradoException {
		Usuario usuarioAuxiliar = null;
		try {
			usuarioAuxiliar = new UsuarioDao().findByLogin(funcionario.getUsuario().getLogin());
		} catch (NoResultException e) {
			
		}
		
		if (usuarioAuxiliar == null) {
			this.funcionarioDao.save(funcionario);
		} else {
			throw new ObjetoJaCadastradoException();
		}
		
	}

}

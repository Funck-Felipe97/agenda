package agenda.service;

import agenda.dao.FuncionarioDao;
import agenda.model.Funcionario;

public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService() {
		this.funcionarioDao =  new FuncionarioDao();
	}
	
	public void save(Funcionario funcionario) {
		this.funcionarioDao.save(funcionario);
	}

}

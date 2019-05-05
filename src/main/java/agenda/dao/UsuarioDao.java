package agenda.dao;

import agenda.model.Usuario;

public class UsuarioDao extends AbstractDao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario findByLogin(String login){
		return  (Usuario)
				super.createNamedQuery("usuario.findByLogin")
				.setParameter("login", login)
				.getSingleResult();
	}
}

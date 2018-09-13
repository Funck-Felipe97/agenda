package agenda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {

	private static EntityManagerFactory factory;

	private JpaUtil() {

	}

	/**
	 * M�todo de cria��o do factory de EntityManager
	 * 
	 * @return EntityManagerFactory
	 * @author Felipe Funck
	 */
	private static EntityManagerFactory getFactory() {
		if (factory == null){
			synchronized (JpaUtil.class) {
				if (factory == null){
					factory = Persistence.createEntityManagerFactory("agendaPU");
				}
			}
		}
		return factory;
	}
	
	/**
	 * M�todo de cria��o de uma unidade de EntityManager
	 * 
	 * @return EntityManagerFactory
	 * @author Felipe Funck
	 */
	public static EntityManager getManager() {
		return getFactory().createEntityManager();
	}
	
	
}

package agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import agenda.util.JpaUtil;

public abstract class AbstractDao<T> {

	private EntityManager manager;
	private Class<T> persistedClass;

	public AbstractDao(Class cls) {
		this.persistedClass = cls;
		this.manager = JpaUtil.getManager();
	}

	/**
	 * Método genérico responsavel por salvar objetos
	 * 
	 * @param Object Objeto a ser salvo
	 * @return Objeto salvo
	 */
	public T save(T object) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(object);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
		return object;
	}

	/**
	 * Método genérico responsavel por atualizar objetos
	 * 
	 * @param Object Objeto a ser atualizado
	 * @return Objeto atualizado
	 */
	public T update(T object) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(object);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
		return object;
	}

	/**
	 * Método genérico responsavel deletar objetos por id
	 * 
	 * @param id Id do objeto a ser deletado
	 */
	public void delete(Long id) {
		T object = findById(id);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			T mergedEntity = manager.merge(object);
			manager.remove(mergedEntity);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}

	}

	/**
	 * Método genérico responsavel deletar objetos
	 * 
	 * @param object Objeto a ser deletado
	 */
	public void delete(T object) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			T mergedEntity = manager.merge(object);
			manager.remove(mergedEntity);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}

	/**
	 * Método responsavel por buscar objetos por id
	 * 
	 * @param id Id do objeto
	 * @return Objeto encontrado
	 */
	public T findById(Long id) {
		return manager.find(persistedClass, id);
	}

	/**
	 * Método responsavel por listar todos objetos
	 * 
	 * @return Lista de objeto encontrado
	 */
	public List<T> findAll() {
		return createQuery("from " + persistedClass.getSimpleName()).getResultList();
	}

	/**
	 * Método responsavel por criar uma Query
	 * 
	 * @return Query criada
	 */
	protected Query createQuery(String query) {
		return manager.createQuery(query, persistedClass);
	}

	/**
	 * Método responsavel por criar uma NamedQuery
	 * 
	 * @return Query criada
	 */
	protected Query createNamedQuery(String query) {
		return manager.createNamedQuery(query, persistedClass);
	}

}

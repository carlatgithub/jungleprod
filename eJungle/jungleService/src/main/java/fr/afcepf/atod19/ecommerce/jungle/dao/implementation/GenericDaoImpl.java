package fr.afcepf.atod19.ecommerce.jungle.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IGenericDao;

public class GenericDaoImpl implements IGenericDao{
	@PersistenceContext(name="myPersistenceUnit")
	protected EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public <T> void deleteEntity(Class<T> entity,Long pk) {
		T obj = getEntityByPk(entity, pk);
		entityManager.remove(obj);
		
	}

	@Override
	public <T> T updateEntity(T entity) {
		return entityManager.merge(entity);
		
	}

	@Override
	public <T> T getEntityByPk(Class<T> entity,Long pk) {
		
		return entityManager.find(entity, pk);
	}

	@Override
	public <T> void persistNewEntity(T entity) {
		entityManager.persist(entity);
		
	}

	

}

package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

public class GenricDao implements Serializable {

	private static final long serialVersionUID = 1L;

	public EntityManager getEntityManager() {
		return Database.getInstance().getEntityManager();
	}
	
}
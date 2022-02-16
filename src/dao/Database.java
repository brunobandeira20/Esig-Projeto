package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

	private static Database singleton = new Database();
	private static EntityManager em;

	private Database() {
		criarEM();
	}
	
	private void criarEM(){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("appweb");
		em = emf.createEntityManager();
	}

	public static Database getInstance() {
		return singleton;
	}

	public EntityManager getEntityManager() {
		if (!em.isOpen()){
			criarEM();
		}
		
		return em;
	}
	

}
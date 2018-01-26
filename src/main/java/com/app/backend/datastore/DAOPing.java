package com.app.backend.datastore;

import javax.persistence.EntityManager;

import com.app.backend.model.Ping;

public class DAOPing {

	public static void insert(Ping ping){
		EntityManager mgr = DSCommons.getEntityManager(); 
		
		mgr.getTransaction().begin();
		mgr.persist(ping);
		mgr.getTransaction().commit(); 
		
		
		mgr.close();
	}
	
}

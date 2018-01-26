package com.app.backend.datastore;

import javax.persistence.EntityManager;

public class DSCommons {
	public static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
}

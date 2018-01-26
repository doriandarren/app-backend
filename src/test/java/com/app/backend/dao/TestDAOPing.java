package com.app.backend.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.datastore.DAOPing;
import com.app.backend.model.Ping;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestDAOPing  {
	
	 private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	  @Before
	  public void setUp() {
	    helper.setUp();
	  }
	
	  @After
	  public void tearDown() {
	    helper.tearDown();
	  }
	
	@Test
	public void testInsert() {

	long time = System.currentTimeMillis();

	Ping debug = mosckPing("hola",time);

	DAOPing.insert(debug);

	Assert.assertNotNull(debug.getKey());
	Assert.assertEquals("hola", debug.getData());
	Assert.assertEquals(time, debug.getTimestamp(),0.1);


	}

	private Ping mosckPing(String data, long currentTimeMillis) {
	Ping debug = new Ping();
	debug.setData(data);
	debug.setTimestamp(currentTimeMillis);
	return debug;
	}
	

}

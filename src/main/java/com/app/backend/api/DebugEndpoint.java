package com.app.backend.api;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.app.backend.datastore.DAOPing;
import com.app.backend.model.Ping;


@Api(name = "debugendpoint", 
	namespace = @ApiNamespace(
								ownerDomain = "qcard.com",
								ownerName = "qcard.com", 
								packagePath="backend.model")
							)

public class DebugEndpoint {

	

    /**
	 * Servicio de prueba, retorna un objeto debug, con saludo y hora
	 * @param name
	 * @return
	 * @throws IOException
	 */
	 @ApiMethod(name = "pingNoAuth", path ="pinnoauth",  httpMethod = HttpMethod.GET)
	  public Ping  pingNoAuth(@Named("message") String value_message){
		 Ping debug = new Ping(); 
		 debug.setData("Pong api nosegura, el tiempo en mili-segundos es: " +
				 System.currentTimeMillis() +" message:" +value_message);

		 
		// String id = String.valueOf(debug.getKey().getId()); 
		// debug.setCodeId(id);
		// debug.setKey(null); 
		 
		 
		 return debug; 
	  }
	 
	 
	 /**
		 * Servicio de prueba, retorna un objeto debug, con saludo y hora
		 * @param name
		 * @return
		 * @throws IOException
		 */
		 @ApiMethod(name = "insert", path ="insert",  httpMethod = HttpMethod.GET)
		  public Ping  insert(@Named("message") String value_message){
			 Ping debug = new Ping(); 
			 
			debug.setData(value_message);
			debug.setTimestamp( System.currentTimeMillis() );
			
			DAOPing.insert(debug); 
			
			
			String id = String.valueOf(debug.getKey().getId()); 
			debug.setCodeId(id);
			debug.setKey(null); 
			 
			
		    return debug;
		  }
		 
		 
		 @ApiMethod(name = "update", path ="update",  httpMethod = HttpMethod.GET)
		  public Ping  update(@NotNull Ping ping){
			 
			 
			 
			 
			 return null; 
		 }
		 
		 
	 
	 
		 

}
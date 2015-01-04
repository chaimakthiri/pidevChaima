package com.esprit.serviceLocator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;





public class ServiceLocator {
	private static ServiceLocator instance;
	private Map<String, Object> cache;
	private Context ctx;
	
	private ServiceLocator() {
		try {
			cache = new HashMap<String, Object>();
			ctx = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	public static ServiceLocator getInstance() {
		if (instance == null)
			instance = new ServiceLocator();
		return instance;
	}
	//syncronise pour les proteger pour les appel concua=rant
	public synchronized Object getProxy(String jndi){ 
		Object objet=null;
		if(cache.get(jndi)!=null){
			return cache.get(jndi);
			
		} else
			try {
				objet =ctx.lookup(jndi);
				cache.put(jndi, objet);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return objet ;
		

}
}

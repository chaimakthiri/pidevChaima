package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.pidev.crud.ManageCategoryRemote;
import com.esprit.pidev.jpa.Service;

public class TestPlatforme {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ManageCategoryRemote proxy = (ManageCategoryRemote) context
				.lookup("ejb:TunexchangeEAR/TunExchangeEJB/ManageCategory!com.esprit.pidev.crud.ManageCategoryRemote");

		List<Service> services = proxy.findAllServicesByCategoryName("aaaaa");
		System.out.println(services.size());

	}

}

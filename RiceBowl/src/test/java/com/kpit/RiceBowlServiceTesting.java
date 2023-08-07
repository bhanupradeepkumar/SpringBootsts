package com.kpit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.layer2.RiceBowl;
import com.kpit.layer3.RiceBowlAlreadyExistException;
import com.kpit.layer4.RiceBowlService;


@SpringBootTest
public class RiceBowlServiceTesting {


	//ALL THE TEST CASES BELOW ARE OF SERVICE TESTING

	@Autowired
	RiceBowlService riceBowlService;

	@Test
	public void findASingleRiceBowlServiceTest() {
		
		RiceBowl ricebowl = riceBowlService.orderingARiceBowl(9);
		System.out.println("ricebowl id    : "+ricebowl.getRicebowlId());
		System.out.println("ricebowl type  : "+ricebowl.getRicebowlType());
		System.out.println("ricebowl price : "+ricebowl.getRicebowlPrice());
		
		
	}
	
	@Test
	public void findAllRiceBowls() {
		List<RiceBowl> ricebowls = riceBowlService.getAllRiceBowl();
		for (RiceBowl ricebowl : ricebowls) {
			System.out.println("ricebowl id    : "+ricebowl.getRicebowlId());
			System.out.println("ricebowl type  : "+ricebowl.getRicebowlType());
			System.out.println("ricebowl price : "+ricebowl.getRicebowlPrice());
			System.out.println("-----------");
		}
	}
	
	@Test
	public void createPizzaTest() throws RiceBowlAlreadyExistException
	{	
		RiceBowl newRiceBowl = new RiceBowl();
		newRiceBowl.setRicebowlId(7);
		newRiceBowl.setRicebowlType("Shravan ricebowl");
		newRiceBowl.setRicebowlPrice(240);
			
		riceBowlService.createRiceBowl(newRiceBowl);
		System.out.println("newRiceBowl  created...");
	}
	
	@Test
	public void modifyRiceBowlTest() 
	{	
		RiceBowl riceBowlToModify = new RiceBowl();
		riceBowlToModify.setRicebowlId(9);
		riceBowlToModify.setRicebowlType("CHICKEN bowl");
		riceBowlToModify.setRicebowlPrice(100);
			
		riceBowlService.modifyRiceBowl(riceBowlToModify);
		System.out.println("ricebowl modified...");
	}
	
	@Test
	public void deleteRiceBowlTest() 
	{	

		riceBowlService.deleteRiceBowl(7);
		System.out.println("ricebowl deleted...");
	}
}

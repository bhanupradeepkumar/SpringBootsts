package com.kpit;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.layer2.RiceBowl;
import com.kpit.layer3.RiceBowlNotFoundException;

import com.kpit.layer3.RiceBowlRepository;

@SpringBootTest
class RiceBowlApplicationTests { //BELOW ALL TESTs are OF DATABASE

	
	//ALL THE TEST CASES BELOW ARE OF REPOSITORY TESTING
	
	@Autowired
	RiceBowlRepository riceBowlRepository; //auto injection done by spring  since @Autowired is there
	
	@Test
	void loadAllRiceBowlsTest() {
		
		List<RiceBowl> riceBowlList = riceBowlRepository.findAll();
		for (RiceBowl ricebowl : riceBowlList) {
			System.out.println("ricebowl ID   : "+ricebowl.getRicebowlId());
			System.out.println("ricebowl TYPE : "+ricebowl.getRicebowlType());
			System.out.println("ricebowl COST : "+ricebowl.getRicebowlPrice());
			System.out.println("---------------");
		}
		
	}
	
	@Test
	void loadARiceBowlByIdTest() {
		
		int ricebowlIdToFind=1;
		Optional<RiceBowl> ricebowl = riceBowlRepository.findById(ricebowlIdToFind);
		
		if(ricebowl.isPresent()) {
			RiceBowl riceBowlObj = ricebowl.get();
		
			System.out.println("ricebowl ID   : "+riceBowlObj.getRicebowlId());
			System.out.println("ricebowl TYPE : "+riceBowlObj.getRicebowlType());
			System.out.println("ricebowl COST : "+riceBowlObj.getRicebowlPrice());
			System.out.println("---------------");
		}
		else {
			//throw exception
			throw new RiceBowlNotFoundException("rice bowl  with id "+ ricebowlIdToFind +" not found");
			
		}
		
	}

	
	@Test
	void modifyPizzaTest() {
		
		RiceBowl modifiedricebowl = new RiceBowl();
		modifiedricebowl.setRicebowlId(1);
		modifiedricebowl.setRicebowlType("mushroom nugget ricebowl");
		modifiedricebowl.setRicebowlPrice(300);
		
		riceBowlRepository.save(modifiedricebowl);
	}
	
	
	@Test
	void createPizzaTest() {
		
		RiceBowl newriceBowl = new RiceBowl();
		newriceBowl.setRicebowlId(90);
		newriceBowl.setRicebowlType("spicy ricebowl");
		newriceBowl.setRicebowlPrice(500);
		
		riceBowlRepository.save(newriceBowl);
	}
	
	@Test
	void removePizzaTest() {
		
		RiceBowl riceBowlToDelete = new RiceBowl();
		riceBowlToDelete.setRicebowlId(4);
		
		riceBowlRepository.delete(riceBowlToDelete);
	}
	
}

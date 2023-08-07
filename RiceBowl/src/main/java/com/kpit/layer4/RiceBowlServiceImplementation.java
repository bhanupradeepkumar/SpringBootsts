package com.kpit.layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kpit.layer2.RiceBowl;
import com.kpit.layer3.RiceBowlAlreadyExistException;
import com.kpit.layer3.RiceBowlNotFoundException;
import com.kpit.layer3.RiceBowlRepository;

@Service // required 
public class RiceBowlServiceImplementation implements RiceBowlService {

	@Autowired
	RiceBowlRepository riceBowlRepository; //IS IT TESTED OK1 OK2 OK3 OK4 OK5
	
	public RiceBowlServiceImplementation() {
		System.out.println("RiceBowlServiceImplementation()....");
	}
	
	public List<RiceBowl> getAllRiceBowl() {
		return riceBowlRepository.findAll();
	}	


	@Override
	public RiceBowl orderingARiceBowl(int id) { //SERVICE MAN
		RiceBowl ricebowlObj = null;
		
										//THE CHEF
		Optional<RiceBowl> foundRiceBowl = riceBowlRepository.findById(id);
		if(foundRiceBowl.isPresent()) {
			ricebowlObj = foundRiceBowl.get(); //retrieve it from the DB 
			ricebowlObj.setRicebowlType(ricebowlObj.getRicebowlType()+" more  added with little extra spices");
		}
		return ricebowlObj;
	}

	@Override
	public void createRiceBowl(RiceBowl ricebowls) throws RiceBowlAlreadyExistException
	{

		RiceBowl ricebowlObj = null;
		Optional<RiceBowl> foundRiceBowl = riceBowlRepository.findById(ricebowls.getRicebowlId());
		if(foundRiceBowl.isPresent()) {
			ricebowlObj = foundRiceBowl.get(); //retrieve it from the DB 
			System.out.println(ricebowlObj.getRicebowlId());
			System.out.println(ricebowlObj.getRicebowlType());
			System.out.println(ricebowlObj.getRicebowlPrice());
			throw new RiceBowlAlreadyExistException("RiceBowl with id alreayd exists : "+ricebowls.getRicebowlId());
		}
		else {
			riceBowlRepository.save(ricebowls);
			System.out.println("ricebowl SAVED");
		}
	}

	@Override
	public RiceBowl modifyRiceBowl(RiceBowl ricebowls) {
		Optional<RiceBowl> foundRiceBowl = riceBowlRepository.findById(ricebowls.getRicebowlId());
		if(foundRiceBowl.isPresent()) {
			riceBowlRepository.save(ricebowls);
			System.out.println("ricebowl MODIFIED");
			
		}
		else {
			throw new RiceBowlNotFoundException("ricebowl with Id not found : "+ricebowls.getRicebowlId());
		}
		
		return ricebowls;
	}

	@Override
	public void deleteRiceBowl(int id) {
		RiceBowl RiceBowlToDelete = null;
		
		Optional<RiceBowl> foundRiceBowl = riceBowlRepository.findById(id);
		if(foundRiceBowl.isPresent()) {
			RiceBowlToDelete = foundRiceBowl.get(); //retrieve it from the DB 
			riceBowlRepository.delete(RiceBowlToDelete);
			System.out.println("RiceBowl DELETED");
			
		}
		else {
			throw new RiceBowlNotFoundException("RiceBowl with Id not found : "+id);
		}
		
	}

}

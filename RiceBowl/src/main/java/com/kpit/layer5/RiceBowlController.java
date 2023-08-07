package com.kpit.layer5;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.layer2.RiceBowl;
import com.kpit.layer3.RiceBowlAlreadyExistException;
import com.kpit.layer3.RiceBowlNotFoundException;
import com.kpit.layer4.RiceBowlService;

@RestController
@RequestMapping("/eatsure/")
public class RiceBowlController {

	@Autowired
	RiceBowlService ricebowlService; //would talk with the chef | PizzaRepository
	
	public RiceBowlController() {
		System.out.println("riceBowlController()");
	}
	
	
	@GetMapping("/getRiceBowl/{id}") //localhost:8080/eatsure/getRiceBowl/1
	public RiceBowl getRiceBowl(@PathVariable("id") Integer pid) {
		System.out.println("rice bowl Controller is ordering ricebowl from the ricebowlService....");
		
		return ricebowlService.orderingARiceBowl(pid);
	}

	//FOR GETTING A RECORD
	@GetMapping("/getRiceBowl") //localhost:8080/eatsure/getRiceBowl
	public List<RiceBowl> getRiceBowl() {
		System.out.println("ricebowl Controller is retrieving all ricebowl from the ricebowlservice....");
		
		return ricebowlService.getAllRiceBowl();
	}
	
	//FOR STORING A RECORD
	@PostMapping("/addRiceBowl") //localhost:8080/eatsure/addRiceBowl
	public ResponseEntity<String> storeARiceBowl(@RequestBody RiceBowl ricebowl) {
		
		System.out.println("ricebowler Controller is storing a Ricebowl...");
		try {
			ricebowlService.createRiceBowl(ricebowl);
			return ResponseEntity.status(HttpStatus.CREATED).body("RiceBowl SUCCESSFULLY Created");
		} catch (RiceBowlAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	//FOR UPDATING A RECORD
	@PutMapping("/updateRiceBowl") //localhost:8080/eatsure/updateRiceBowl
	public ResponseEntity<String> modifyAPizza(@RequestBody RiceBowl ricebowl) {
		
		System.out.println("Pizza Controller is updating a pizza...");
		try {
			ricebowlService.modifyRiceBowl(ricebowl);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("ricebowl SUCCESSFULLY MODIFIED");
		} catch (RiceBowlNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	//FOR DELETING A RECORD
		@DeleteMapping("/deleteRiceBowl/{pid}") //localhost:8080/eatsure/deleteRiceBowl
		public ResponseEntity<String> removeAPizza(@PathVariable("pid") int riceBowlIdToDelete) {
			
			System.out.println("Pizza Controller is updating a pizza...");
			try {
				ricebowlService.deleteRiceBowl(riceBowlIdToDelete);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("ricebowl SUCCESSFULLY DELETED");
			} catch (RiceBowlNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		}

}

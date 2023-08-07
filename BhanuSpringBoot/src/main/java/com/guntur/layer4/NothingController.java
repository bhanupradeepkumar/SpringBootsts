package com.guntur.layer4;


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

import com.guntur.layer1.Nothing;
import com.guntur.layer2.CustomerAlreadyExistException;
import com.guntur.layer2.CustomerNotFoundException;
import com.guntur.layer3.NothingService;

@RestController
@RequestMapping("/nothing/")
public class NothingController {
	@Autowired 
	NothingService nothingService;
	
	public NothingController() {
		
	}
	
	@GetMapping("/{id}")
	public Nothing getControlCusDetails(@PathVariable("id") Integer pid) {
		
		
		return nothingService.getCustomerDetails(pid);
		
	}
	
	@GetMapping("/read")
	public List<Nothing> getAllControlDetails(){
		return nothingService.getAllCustomerDetails();
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> storeAControlRecord(@RequestBody Nothing nothing){
		System.out.println("storing details ..");
		try {
			 nothingService.createCustomerDetails(nothing);
			 return ResponseEntity.status(HttpStatus.CREATED).body("details successfully created and stored ...");
			
		}catch(CustomerAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>  updateAcontrolRecord(@RequestBody Nothing nothing){
		System.out.println("updating details..");
		try {
			nothingService.modifyCustomerDetails(nothing);
			return ResponseEntity.status(HttpStatus.CREATED).body("details successfully updated and stored ...");
		}catch(CustomerNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		
	}
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<String>  deleteAcontrolRecord(@PathVariable("id") int idToDelete){
		try {
		 nothingService.deleteCustomerDetails(idToDelete);
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" successfully deleted ...");
	}catch(CustomerNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
		
	}
	

}

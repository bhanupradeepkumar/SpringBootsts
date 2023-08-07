package com.guntur.layer3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guntur.layer1.Nothing;
import com.guntur.layer2.CustomerAlreadyExistException;
import com.guntur.layer2.CustomerNotFoundException;
import com.guntur.layer2.NothingRepository;

@Service
public class NothingServiceImplementation implements NothingService {
	
	@Autowired
	NothingRepository nothingRepository;
	public NothingServiceImplementation() {
		//default constructor 
	}

	@Override
	public Nothing getCustomerDetails(int id) {
		Nothing nothingObj = null;
		
		Optional<Nothing> customerInfo = nothingRepository.findById(id);
		if(customerInfo.isPresent()) {
			nothingObj=customerInfo.get();
		}
		// TODO Auto-generated method stub
		return nothingObj;
	}

	@Override
	public List<Nothing> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return nothingRepository.findAll();
	}

	@Override
	public void createCustomerDetails(Nothing nothings) throws CustomerAlreadyExistException {
		// TODO Auto-generated method stub
		Nothing nothingObj = null;
		
		Optional<Nothing> createCusInfo = nothingRepository.findById(nothings.getCustomerId());
		if(createCusInfo.isPresent()) {
//			nothingObj = createCusInfo.get();
			throw new CustomerAlreadyExistException("customer already exits with id :"+nothings.getCustomerId());
		}
		else {
			nothingRepository.save(nothings);
			System.out.println("details saved...");
		}
		
	}

	@Override
	public Nothing modifyCustomerDetails(Nothing nothings) {
		// TODO Auto-generated method stub
		
		Optional<Nothing> modifyInfo = nothingRepository.findById(nothings.getCustomerId());
		if(modifyInfo.isPresent()) {
			nothingRepository.save(nothings);
			System.out.println("details modified..");
		}else {
			throw new CustomerNotFoundException("No customer found with id :"+nothings.getCustomerId());
		}
		return nothings;
	}

	@Override
	public void deleteCustomerDetails(int id) {
		// TODO Auto-generated method stub
		Nothing nothingDelObj = null;
		Optional<Nothing>  deleteCusInfo  = nothingRepository.findById(id);
		if(deleteCusInfo.isPresent()) {
			nothingDelObj = deleteCusInfo.get();
			nothingRepository.delete(nothingDelObj);
			System.out.println("customer deleted with id :"+id);
		}
		else {
			throw new CustomerNotFoundException("customer not found to delete with id :"+id);
		}
		
	}
	
	
	

}

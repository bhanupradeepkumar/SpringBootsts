package com.guntur.layer3;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guntur.layer1.Nothing;
import com.guntur.layer2.CustomerAlreadyExistException;



@Service
public interface NothingService {

	Nothing getCustomerDetails(int id);
	List<Nothing> getAllCustomerDetails();
	
	void createCustomerDetails(Nothing nothings) throws CustomerAlreadyExistException;
	
	Nothing modifyCustomerDetails(Nothing nothings);
	
	void deleteCustomerDetails(int id);
	
	
}

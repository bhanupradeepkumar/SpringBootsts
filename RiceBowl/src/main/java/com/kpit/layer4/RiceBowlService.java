package com.kpit.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpit.layer2.RiceBowl;
import com.kpit.layer3.RiceBowlAlreadyExistException;

@Service // same as @Component | @Repository
public interface RiceBowlService {

	RiceBowl orderingARiceBowl(int id);
	List<RiceBowl> getAllRiceBowl();
	
	void createRiceBowl(RiceBowl ricebowls) throws RiceBowlAlreadyExistException;
	RiceBowl modifyRiceBowl(RiceBowl ricebowls);
	void  deleteRiceBowl(int id);

}

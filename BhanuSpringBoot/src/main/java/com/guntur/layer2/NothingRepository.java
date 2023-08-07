package com.guntur.layer2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guntur.layer1.Nothing;
@Repository
public interface NothingRepository extends JpaRepository<Nothing, Integer>{
	

}

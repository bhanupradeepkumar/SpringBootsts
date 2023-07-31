package com.kpit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankProjectApplicationTests {

	@Autowired
	SavingsAccount savObj;
	
	@Test
	void contextLoads() {
		System.out.println("bank test case 1");
		savObj.withdraw(5000);
		savObj.deposit(75000);
	}

}

package com.kpit;

import org.springframework.stereotype.Component;

@Component
public class SavingsAccount {

	public SavingsAccount() {
		System.out.println("SavingsAccount ctr...");
	}
	
	public void withdraw(float amt) {
		System.out.println("SavingsAccount : withdraw() "+amt);
	}
	public void deposit(float amt) {
		System.out.println("SavingsAccount : deposit() "+amt);
	}

}

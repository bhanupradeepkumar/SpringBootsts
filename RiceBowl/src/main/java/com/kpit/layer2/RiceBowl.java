package com.kpit.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bawarchi") //real table's name
public class RiceBowl { //<-- YOUR POJO 

	@Id //<--marked as primary key
	@Column(name="ricebowlid") //actual table column's name
	private int ricebowlId;

	@Column(name="ricebowltype") //actual table column's name
	private String ricebowlType;
	
	@Column(name="ricebowlcost") //<-actual table column's name
	private float ricebowlPrice;
	
	public RiceBowl() {
		System.out.println("RiceBowl() constructor....");
	}
	//generate all the setters/getters

	public int getRicebowlId() {
		return ricebowlId;
	}

	public void setRicebowlId(int ricebowlId) {
		this.ricebowlId = ricebowlId;
	}

	public String getRicebowlType() {
		return ricebowlType;
	}

	public void setRicebowlType(String ricebowlType) {
		this.ricebowlType = ricebowlType;
	}

	public float getRicebowlPrice() {
		return ricebowlPrice;
	}

	public void setRicebowlPrice(float ricebowlPrice) {
		this.ricebowlPrice = ricebowlPrice;
	}

	
}

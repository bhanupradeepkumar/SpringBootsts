package entity; //1. it must be in a package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO | Java Bean | Component

//5 aspects


//Object Relation Mapping = Hibernate | Toplink ORM F/w
// JAVA    TABLE MAPPING

//2 - must be public

@Entity
@Table(name="mydept120") //ur case mydept120
public class Department //matching class as per the Dept Table
{

	//3 private data 
	@Id //primary key
	@Column(name="deptno")
	private int departmentNumber; //matching with DEPTNO column of the Dept Table
	
	@Column(name="dname")
	private String departmentName; //DEPTNAME
	
	@Column(name="loc")
	private String departmentLocation; //LOC
	
	
	//4 a public no-arg constructor
	
	public Department() {
		System.out.println("Department() .....");
	}
	//5 setter/getters


	public int getDepartmentNumber() {
		return departmentNumber;
	}


	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentLocation() {
		return departmentLocation;
	}


	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	

}

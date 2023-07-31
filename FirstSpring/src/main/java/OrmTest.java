import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Department;

/*

	Framework = semi-developed application
		
		
		photo frame shop
			  |
		1. time is saved
		2. varieties of frame
		3. different type and colors of frames
		4. shapes of frames
		5. designs of frames
		6. material of frames
		7. various glass types
		8. no need to learn the frame creation art
		9. its a ready made shop for us to select 
		
		10. this shop does not have the photo 
			
			
			Entity = a business entity managed via its primary key
			
*/
public class OrmTest {

	public static void main(String[] args) { 
		
		//begin to interact with ORM "Framework" now
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity Manager : "+entityManager);
		
		System.out.println("**************************************************");
		System.out.println("----lets INSERT record----");
		
		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println("Got the transaction....");
			transaction.begin();
				Department newDept = new Department();
				newDept.setDepartmentNumber(200);
				newDept.setDepartmentName("Google");
				newDept.setDepartmentLocation("Netherlands");
			
				entityManager.persist(newDept);
			transaction.commit();
			System.out.println("INSERTED the newDept object....");
		System.out.println("**************************************************");

		System.out.println("----lets MODIFY record----");
		
		EntityTransaction transaction2 = entityManager.getTransaction();
		System.out.println("Got the transaction....");
			transaction2.begin();
				Department existingDept = entityManager.find(Department.class,18);
				System.out.println("Current Dept Name : "+existingDept.getDepartmentName());
				System.out.println("Current Dept Loc  : "+existingDept.getDepartmentLocation());
				System.out.println("Setting new values....");	
				//NEVER MODIFY THE PRIMARY KEY via setter, it will contradict 
				existingDept.setDepartmentName("QMS");
				existingDept.setDepartmentLocation("Nagpur");
			
				entityManager.merge(existingDept); //fires the UPDATE query
			transaction2.commit();
			System.out.println("MODIFED the existing Object ....");
			
		System.out.println("**************************************************");

		System.out.println("----lets DELETE A record----");
		
		EntityTransaction transaction3 = entityManager.getTransaction();
		System.out.println("Got the transaction....");
			transaction3.begin();
				Department deptToDelete = entityManager.find(Department.class,10);
				System.out.println("Current Dept Name : "+deptToDelete.getDepartmentName());
				System.out.println("Current Dept Loc  : "+deptToDelete.getDepartmentLocation());
				System.out.println("Deleting this object");	
			
				entityManager.remove(deptToDelete);//fires the DELETE query
			transaction3.commit();
			System.out.println("DELETED the existing Object ....");
			
		System.out.println("**************************************************");

		
		Query theQuery = entityManager.createQuery(" from Department"); // JPQL | select * from dept <-- internally fired
		List<Department> deptList = theQuery.getResultList();
		System.out.println("got the JPQL run and fired...");
		
		Iterator<Department> iterator = deptList.iterator();
		System.out.println("Got the Iterator...");
		
		while(iterator.hasNext()) {
			Department dept = iterator.next();
			
			System.out.println("DEPTNO    : "+dept.getDepartmentNumber());
			System.out.println("DEPT NAME : "+dept.getDepartmentName());
			System.out.println("LOCATION  : "+dept.getDepartmentLocation());
			System.out.println("---------------------------");
	
		}
	
	
		entityManager.close();
		System.out.println("Closing the entity manager....");
	}

}

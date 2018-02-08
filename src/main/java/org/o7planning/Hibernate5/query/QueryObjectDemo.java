package org.o7planning.Hibernate5.query;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.o7planning.Hibernate5.HibernateUtils;
import org.o7planning.Hibernate5.entities.Employee;

public class QueryObjectDemo {

	public static void main(String args[]) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start the transaction
			session.getTransaction().begin();
			
			// Create an HQL statement, query the object.
			// Equivalent to the SQL statement:
			//SELECT e.* FROM EMPOYEE e ORDER BY e.EMP_NAME, e.EMP_NO
			String sql = "Select e from " + Employee.class.getName() + " e order by e.empName, e.empNo";
			
			// Create query object
			Query query = session.createQuery(sql);
			
			// Execute the query
			List<Employee> employees = query.getResultList();
			
			// Loop
			for(Employee emp : employees) {
				System.out.println("* EMP: " + emp.getEmpNo() + " : " + emp.getEmpName());
			}
			
			System.out.println("************************");
			
			// Query 2 with parameters
			// Select e.* from EMPLOYEE e cross join DEPARTMENT d
            // where e.DEPT_ID = d.DEPT_ID and d.DEPT_NO = :deptNo;
			// e.department is a joined column in Employee with variable department, then we are using the properties of the department.deptNo
			String sql2 = "Select e from " + Employee.class.getName() + " e where e.department.deptNo =:deptNo";
			
			// Create query object
			Query query2 = session.createQuery(sql2);
			query2.setParameter("deptNo", "D10");
			
			// Execute the query2
			List<Employee> employees2 = query2.getResultList();
			
			//Loop
			for(Employee emp2 : employees2) {
				System.out.println("** EMP: " + emp2.getEmpNo() + " : " + emp2.getEmpName());
			}
			
			// Commit data.
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			// Rollback incase of error
			session.getTransaction().rollback();
		}
	}
}

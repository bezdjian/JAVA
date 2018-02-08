package org.o7planning.Hibernate5.query;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.o7planning.Hibernate5.HibernateUtils;
import org.o7planning.Hibernate5.entities.Department;
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
			
			System.out.println("******* WHERE CLAUSE *****************");
			
			// Query 2 with parameters
			// Select e.* from EMPLOYEE e cross join DEPARTMENT d
            // where e.DEPT_ID = d.DEPT_ID and d.DEPT_NO = :deptNo;
			// e.department is a joined column in Employee with variable department, then we are using the properties of the department.deptNo
			String sql2 = "Select e from " + Employee.class.getName() + " e where e.department.deptNo =:deptNo";
			
			// Create query object
			Query query2 = session.createQuery(sql2);
			query2.setParameter("deptNo", "D20");
			
			// Execute the query2
			List<Employee> employees2 = query2.getResultList();
			
			//Loop
			for(Employee emp2 : employees2) {
				System.out.println("**DEP NO#: D20 | EMP NO#: " + emp2.getEmpNo() + " | EMP NAME: " + emp2.getEmpName());
			}
			
			System.out.println("********** SELECT COLUMNS **************");
			
			 // Query some columns.
            String sql3 = "Select e.empId, e.empNo, e.empName from "
                    + Employee.class.getName() + " e ";
 
            Query query3 = session.createQuery(sql3);
  
            // Execute Query.
            // Get the array of Object
            List<Object[]> datas = query3.getResultList();
 
            for (Object[] emp : datas) {
                System.out.println("***Emp Id: " + emp[0]);
                System.out.println("***Emp No: " + emp[1]);
                System.out.println("***Emp Name: " + emp[2]);
            }
            
            System.out.println("********** GET DEPARTMENT WITH ITS EMPLOYEES **************");
            
            String deptNo = "D20";
            Department dept = getDepartment(session, deptNo);
            if(dept != null) {
            	Set<Employee> deptEmployees = dept.getEmployees();
                
                System.out.println("Department Name: " + dept.getDeptName());
                for(Employee deptEmps : deptEmployees) {
                	System.out.println("Employee Name in " + dept.getDeptName() + ": " + deptEmps.getEmpName() + " in " + dept.getLocation());
                }
            }else {
            	System.err.println("Department with NO# " + deptNo + " not found");
            }
            
			
			// Commit data.
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			// Rollback incase of error
			session.getTransaction().rollback();
		}
	}
	
	public static Department getDepartment(Session session, String deptNo) {
		try {
			String q = "Select d from " + Department.class.getName() + " d where d.deptNo =:deptNo";
			Query query = session.createQuery(q);
			query.setParameter("deptNo", deptNo);
			return (Department) query.getSingleResult();	
		}catch(NoResultException e) {
			System.err.println("Error message from getDepartment: " + e.getMessage());
		}
		return null;
		
	}
}

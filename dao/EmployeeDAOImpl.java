package com.dev.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dev.spring.beans.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQLUnit");
	
	@Override
	public Employee createEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Employee> query =em.createQuery("from Employee e where e.id = :empid", Employee.class);
		query.setParameter("empid", employeeId);
		List<Employee> employees = query.getResultList();
		Employee employee = employees.get(0);
		if(employee != null)
		{
		return employee;
		}
		return null;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee employees = em.find(Employee.class, employee.getId());
		employees.setEmail(employee.getEmail());
		em.getTransaction().commit();
		if(employee != null)
		{
		return true;
		}
		return false;
	}

	@Override
	public Boolean deleteEmployee(int employeeId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Employee e where e.id = :empid");
		query.setParameter("empid", employeeId);
		Integer state = query.executeUpdate();
		em.getTransaction().commit();
		if(state > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> query = em.createQuery("Select e From Employee e", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

}

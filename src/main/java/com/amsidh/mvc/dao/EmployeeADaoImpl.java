package com.amsidh.mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amsidh.mvc.domain.EmployeeA;
@Repository("employeeADao")
public class EmployeeADaoImpl implements EmployeeADao {

	
	public EmployeeADaoImpl() {
	  System.out.println("EmployeeADaoImpl is created");
	}

	@PersistenceContext(unitName="PersistenceUnitA")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void persistEmployee(EmployeeA employee) throws Exception{
		
		entityManager.persist(employee);
	}

	

}

package com.amsidh.mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amsidh.mvc.domain.EmployeeB;
@Repository("employeeBDao")
public class EmployeeBDaoImpl implements EmployeeBDao {

	@PersistenceContext(unitName="PersistenceUnitB")
	private EntityManager entityManager;

	
	public EmployeeBDaoImpl() {
		System.out.println("EmployeeBDaoImpl is created");
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public void persistEmployee(EmployeeB employee) throws Exception {
		
		entityManager.persist(employee);
		//throw new Exception();
	}

}

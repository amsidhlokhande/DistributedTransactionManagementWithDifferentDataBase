package com.amsidh.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amsidh.mvc.dao.EmployeeADao;
import com.amsidh.mvc.dao.EmployeeBDao;
import com.amsidh.mvc.domain.EmployeeA;
import com.amsidh.mvc.domain.EmployeeB;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeADao")
	private EmployeeADao employeeADao;
	@Autowired
	@Qualifier("employeeBDao")
	private EmployeeBDao employeeBDao;
	

	public void setEmployeeADao(EmployeeADao employeeADao) {
		this.employeeADao = employeeADao;
	}

	public void setEmployeeBDao(EmployeeBDao employeeBDao) {
		this.employeeBDao = employeeBDao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void persistEmployee(EmployeeA employeeA, EmployeeB employeeB) throws Exception {
		System.out.println("Persist A");
		employeeADao.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
		employeeBDao.persistEmployee(employeeB);
		System.out.println("Persist B okk");

	}

}

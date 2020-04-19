package com.amsidh.mvc.servlets;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.mvc.domain.EmployeeA;
import com.amsidh.mvc.domain.EmployeeB;
import com.amsidh.mvc.service.EmployeeService;

public class App {

	public static void main(String[] args) throws Exception {
		org.apache.derby.jdbc.EmbeddedXADataSource dd;
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeA em1 = new EmployeeA();
		em1.setId("123");
		em1.setName("AmsidhA");
		em1.setAge(35);
		EmployeeB em2 = new EmployeeB();
		em2.setId("123");
		em2.setName("AsmidhB");
		em2.setAge(31);
		EmployeeService emService = (EmployeeService) context.getBean("employeeService");
		emService.persistEmployee(em1, em2);
		context.close();
	}

}


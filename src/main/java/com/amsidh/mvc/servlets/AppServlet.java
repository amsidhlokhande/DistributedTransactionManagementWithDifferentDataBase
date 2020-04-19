package com.amsidh.mvc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.amsidh.mvc.domain.EmployeeA;
import com.amsidh.mvc.domain.EmployeeB;
import com.amsidh.mvc.service.EmployeeService;

@Component("appServlet")
public class AppServlet 
implements HttpRequestHandler {

	@Autowired
	private EmployeeService employeeService;
    
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmployeeA employeeA = new EmployeeA();
		employeeA.setId("123");
		employeeA.setName("John");
		employeeA.setAge(35);

		EmployeeB employeeB = new EmployeeB();
		employeeB.setId("123");
		employeeB.setName("Mary");
		employeeB.setAge(31);

		try {
			employeeService.persistEmployee(employeeA, employeeB);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hello World!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Java Code Geeks </h1>");
			out.println("<h2>Both employees are inserted!</h2>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception ex) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hello World!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Java Code Geeks </h1>");
			out.println("<h2>Transaction Rollback!</h2>");
			out.println("</body>");
			out.println("</html>");
			ex.printStackTrace();
		}
	}

}

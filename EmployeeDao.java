package com.web.RestWebServiceClient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

// DAO : Data Access Objects
@Repository
public class EmployeeDao {
	
public
	
 public  List<Employee> getAllEmployees()
	{
		String uri = "http://localhost:8080/1.0/getEmployeeList";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Employee>> response = restTemplate.exchange(
				  uri,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Employee>>(){});
				List<Employee> employees = response.getBody();
		return employees;
	}
	 
	 public  Employee getEmployeeByID(int id)
		{
			String uri = "http://localhost:8080/1.0/employee/"+id;
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Employee> response = restTemplate.exchange(
					  uri,
					  HttpMethod.GET,
					  null,
					  Employee.class);
					Employee employee = response.getBody();
			return employee;
		}
	 
	 public  String saveEmployee(Employee e)
		{
			
		 String uri = "http://localhost:8080/1.0/employee";
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Employee> request = new HttpEntity<>(e);
			ResponseEntity<String> response = restTemplate
					  .exchange(uri, HttpMethod.POST, request, String.class);
					String responseEmployee = response.getBody();
			return responseEmployee;
		 
		 
		 
		}
	 
	 
	 public  String updateEmployee(Employee e)
		{
			
		 String uri = "http://localhost:8080/1.0/employee";
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Employee> request = new HttpEntity<>(e);
			ResponseEntity<String> response = restTemplate
					  .exchange(uri, HttpMethod.PUT, request, String.class);
					String responseEmployee = response.getBody();
			return responseEmployee;
		 
		 
		 
		}
	 
	
	 
	 public  String deleteEmployee(Employee e)
		{
		 String uri = "http://localhost:8080/1.0/employee/"+e.getId();
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Employee> request = new HttpEntity<>(e);
			ResponseEntity<String> response = restTemplate
					  .exchange(uri, HttpMethod.DELETE, request, String.class);
					String responseEmployee = response.getBody();
			return responseEmployee;
		}
	

}

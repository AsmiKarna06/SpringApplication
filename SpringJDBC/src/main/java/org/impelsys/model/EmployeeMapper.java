package org.impelsys.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("in employee mapper");
		Employee emp = new Employee();
		emp.setEmpName(rs.getString("emp_name"));
		emp.setGender(rs.getString("gender"));
		emp.setExperience(rs.getInt("experience"));
		emp.setSalary(rs.getInt("salary"));
		return emp;
	}
	
}

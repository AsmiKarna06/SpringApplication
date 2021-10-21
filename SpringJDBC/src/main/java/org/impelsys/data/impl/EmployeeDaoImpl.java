package org.impelsys.data.impl;

import org.impelsys.data.EmployeeDao;
import org.impelsys.model.Employee;
import org.impelsys.model.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao{
	
	JdbcTemplate jdbcTemplate;

	public int saveEmp(Employee e){
		String sql="insert into Employee values(empName,age) values(:name, :age)";
	//	SqlParameterSource 
		return 1;
	}

	public Employee getEmployee(int id){
		String sql="select * from employee where emp_id=?";		
		Employee result=(Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},new EmployeeMapper());
		
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}

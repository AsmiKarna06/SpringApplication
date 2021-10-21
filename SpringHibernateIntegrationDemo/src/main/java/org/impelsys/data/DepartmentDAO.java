package org.impelsys.data;

import java.util.List;

import org.impelsys.model.Department;

public interface DepartmentDAO {
	
	public boolean save();
	
	public boolean delete();

	public int add(Department dept);
	
	public List<Department> getAllDepartments();

//	public void assignEmployeeProjects();
}

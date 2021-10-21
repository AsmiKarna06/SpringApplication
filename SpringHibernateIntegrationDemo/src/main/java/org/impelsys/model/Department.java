package org.impelsys.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 	//POJO
@Table(name="Department")
public class Department {
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int deptId;
	
	@Column(name="dept_name")
	String  deptName;
	
	@Column(name="hod_name")
	String hodName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)	//,mappedBy="department"	//department is the name of property not column name
	@JoinColumn(name="department")
	private Set<Employee> employees;	//
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}

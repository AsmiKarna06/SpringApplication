package org.impelsys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

//@Component
@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	int empId;
	
	@Column(name="emp_name",length=40)
	String empName;
	String empPhoneNum;
	String experience;
	String gender;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Date dob;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)	
	@JoinColumn(name="deptId", referencedColumnName="dept_id")	//emp table deptId is a FK to the depIt of the employee table
	Department department; 
	
	int age;
	int salary;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)			//emp has onetoone association
	@JoinColumn(name="emp_acct_id", referencedColumnName="accountId") //cascade=CascadeType.ALL
	BankAccount bankAccount;	//emp have on bankaccount//bankaccount and emp is a bidirectional realationship
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	//in the third table will have two column emp_id and pr_id
	@JoinTable(name="EMP_PROJECTS",
	joinColumns={@JoinColumn(name="EMPLOYEE_ID",referencedColumnName="emp_id")},inverseJoinColumns={@JoinColumn(name="PROJECT_ID",referencedColumnName="PR_ID")}
	)
	private List<Project> projectsList;
	
	
	public Employee(String ename,String phone,String gender){
		this.empName=ename;
		this.empPhoneNum=phone;
		this.gender=gender;
	}
	public Employee(){
		
	}

	public static class EmployeeFactory{
		public static Employee create(){
			return  new Employee();
		}
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhoneNum() {
		return empPhoneNum;
	}
	public void setEmpPhoneNum(String empPhoneNum) {
		this.empPhoneNum = empPhoneNum;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<Project> getProjectsList() {
		return projectsList;
	}
	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", gender=" + gender + ", dob=" + dob + ", department=" + department + ", age=" + age
				+ ", salary=" + salary + ", bankAccount=" + bankAccount + ", projectsList=" + projectsList + "]";
	}

	
	
}

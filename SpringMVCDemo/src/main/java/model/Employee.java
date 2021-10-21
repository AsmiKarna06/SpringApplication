package model;

import java.util.Date;

import javax.print.attribute.standard.Severity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import customannotations.Year;

//Model class
@Component
public class Employee {
	String empID;
	@NotNull
	@Size(min=3,max=30,message="Employee number should be more than 3 character and less than 30 Character")

	@Pattern(regexp="[^0-9]*")
	String empName;
	@NotNull(message="Phone number is requeried")
	
	String empPhoneNum;
	
	
	String shift;
	@Range(min=2,max=5,message="Experience should be between 2 and 5 years")
	int empExperience;
	
	@NotNull(message=" date of birth cannot be empty")
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
//	@Year(2001)
	@Year(value= 2001, message="please specify dateofbirth upto 2001", payload=Severity.Error.class)
	Date dateofBirth;
	@NotNull(message="Age is requeried")
	@Min(20)
	int age;
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
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
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", shift=" + shift
				+ ", empExperience=" + empExperience + ", dateofBirth=" + dateofBirth + ", age=" + age + "]";
	}
}

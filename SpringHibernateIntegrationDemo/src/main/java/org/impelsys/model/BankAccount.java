package org.impelsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="bank_account")//table name as bank_account
public class BankAccount {	//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountId",unique=true,nullable=false)
	private Integer accountId;
	
	@Column(name="ACC_TYPE",length=20)
	private String accountType;

	@Column(name="BANK_NAME",length=100)
	private String bankName;
	
	@Column(name="IFSC")
	private String ifsc;
	
	@OneToOne(mappedBy="bankAccount")
	private Employee employee;	//bankaccount and employee is bidirectional
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

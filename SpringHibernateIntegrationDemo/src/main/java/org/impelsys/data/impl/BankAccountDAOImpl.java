package org.impelsys.data.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.impelsys.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	public void saveOrUpdate(BankAccount bankAccount){
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(bankAccount); //is there is no record it will save and there is it will update
		tx.commit();
		session.close();
	}
	public boolean delete(BankAccount bankAccount){
		return true;
	}
	public List<BankAccount> getAllBankAccounts(){
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Query <BankAccount> query=session.createQuery("from BankAccount",BankAccount.class);
		List<BankAccount> listAccounts = query.list();
		return listAccounts;
	}
}

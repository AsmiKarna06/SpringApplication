package org.impelsys.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.impelsys.data.EmployeeDao;
import org.impelsys.model.Employee;
import org.impelsys.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("hibernateDao")
@Transactional
//@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao{
	
	private static final List<Employee> ArrayList = null;


	@Autowired
	SessionFactory sessionFactory;
	Transaction tx=null;
	
	public void assignEmployeeProjects()
	{
		List<Employee> empList = getEmployeeList();
		List<Project> projectsList = new ArrayList();
		for(int i=1;i<3 ;i++)
		{
			Project p = new Project();
			p.setProjectName("Projects" + i);
			projectsList.add(p);
		}
	//	Session session =sessionFactory.getCurrentSession();
		Session session =sessionFactory.openSession();
		if(!session.getTransaction().isActive()){
			tx=session.beginTransaction();
			System.out.println("Transaction begin");
		}
		if(empList!=null){
			System.out.println("At assign Projects");
			for(Employee emp : empList){
				emp.setProjectsList(projectsList);
				session.saveOrUpdate(emp);
			}
			if(tx!=null && tx.isActive())
				System.out.println("At commit");
			tx.commit();
			session.close();
		}
	//	tx.commit();
//		session.close();
	}

	public int addEmployee(Employee emp)//emp is in TRANSIENT state
	{  
		System.out.println("Adding employee (in HibernateDao)");
		Session session=null;
		Integer id;
		try
		{	
			//SessionFactory sf=HibernateUtil.getSessionFactory();	
			session =sessionFactory.openSession();
			tx=session.beginTransaction();
			id = (Integer)session.save(emp);  //insert an employee record in db //emp is in PERSISTENT state
			tx.commit(); //only the changes are persisted to database
			return id;
		
		}
		catch (Exception e)
		{
			tx.rollback();
			return 0;
		}
		finally
		{
			if(session!=null)
				session.close();           //emp is in DETACHED state
			session = sessionFactory.openSession();
			session.beginTransaction();
			//emp.setEmpName("asmi");
			session.update(emp);
			session.getTransaction().commit();
			session.close();
			//emp is in DETACHED state
		}
		
	}
	
	@Override
	public boolean delete(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=null;
		tx=session.beginTransaction();
		//session.delete(arg0);
		return EmployeeDao.super.delete(emp);
	}
	
	

	@Override
	public int updateEmployeeDepartment(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		Query query = session.createQuery("update Employee where empId=:i");
		Query<Employee> query = session.createQuery("update Employee set department=:d where empId=:i");
//		query.setParameter("d",emp.getDepartment().getDeptId());
		query.setParameter("d",emp.getDepartment());
		query.setParameter("i", emp.getEmpId());
		int status = query.executeUpdate();
		session.getTransaction().commit();
		return status;
	}

	@Override
	public Employee getEmployees(int empId) {
		// TODO Auto-generated method stub
		//List <Employee> empList = new ArrayList<Employee>();
		
		/* Creates a new session object which we need to flush explicitly
		  *we need to close it explicitly
		  *we dont need to configure any property to call this method
		  *in single threaded application. openSession is slower than getcurrentsession()
		*/
		
		/* *getCurrentSession()-> will create a session if not existing,
		   *else uses same session which is in the hibernate context.
		   *we dont need to explicitly flush or close the session*/
		Session session = sessionFactory.openSession();  //session is not thread safe object
		
		Employee emp = session.get(Employee.class,new Integer(empId));            //PERSISTENT state
		//empList.add(emp);
		session.close();
		return emp;
	}

	@Override
	public Long getEmployeesCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String totalCountQuery = "Select count(e.empId) from Employee e";
		Query qry = session.createQuery(totalCountQuery);
		List<Employee> empList = qry.list();
		Long resultCount = (Long)qry.uniqueResult();
		return resultCount.longValue();
	}
	
	@Override
	public List<Employee> getEmployeeList(int from,int noOfRows) 
	{
		Session session = sessionFactory.getCurrentSession();
		if(!session.beginTransaction().isActive());
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		query.setFirstResult(from);
		query.setMaxResults(noOfRows);
		List<Employee> empList = query.list();
		return empList;
		
	}
	@Override
	public List<Employee> getEmployeeList() 
	{
		// TODO Auto-generated method stub
		
//		----new JJPA Criteria API which is to be used instead of the deprecated Hibernate Criteria API
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		CriteriaBuilder cb =  session.getCriteriaBuilder();		//used to bukid criteai buikder class
	    CriteriaQuery<Employee> cQuery = cb.createQuery(Employee.class);	//it has different method so refering to emloyee.class
	    Root<Employee> root=cQuery.from(Employee.class);		//
	    cQuery.select(root);
//	    javax.persistence.Query qry= session.createQuery(cQuery); //obtaining hte query from session of type javax.persistence
	    TypedQuery<Employee> qry= session.createQuery(cQuery); //obtaining hte query from session of type javax.persistence
		
	    List<Employee> empList = qry.getResultList();
		//session.getTransaction().commit();
		return empList;
	}

	
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//CRITERAI API
		Criteria criteria = session.createCriteria(Employee.class);
	
		//total salary expenses
		//criteria.setProjection(Projections.sum("salary"));
		//Projections
	//	List totalSal =criteria.list();
	//	System.out.println("Total salary expenses: "+totalSal.get(0));

	
		//fetch all employees earning equal to 30000
		criteria.add(Restrictions.gt("salary",5000));
		
		/*//fetch all employees earning more than30000
		criteria.add(Restrictions.gt("salary",30000));
		
		//fetch all employees earning less than 30000
		criteria.add(Restrictions.lt("salary",30000));
		
		
		//fetch all employees earning less than 30000
		criteria.add(Restrictions.isNull("salary"));
		

		//fetch all employees earning less than 30000
		criteria.add(Restrictions.isNotNull("salary"));
		

		//fetch all employees earning less than 30000
		criteria.add(Restrictions.isNotEmpty("salary"));*/
				
		//fetch all employees earning less than 30000 and more than 20000
		/*criteria.add(Restrictions.between("salary",5000,30000));
		criteria.setProjection(Projections.distinct(Projections.property("salary")));*/
		
		/*//fetch all employees name start with A
		criteria.add(Restrictions.like("empName","A%"));  //fetches both A a
		
		//fetch all employees name start with A
		criteria.add(Restrictions.ilike("salary","A%"));
		

		//fetch all employees above 25 and earning more than 50000
		Criterion age = Restrictions.gt("age",25);             //2 conditions
		Criterion salary = Restrictions.gt("salary",50000);
		LogicalExpression andExp = Restrictions.and(age,salary);    //adding tat to and logicalexpression
		criteria.add(andExp);
		criteria.addOrder(Order.desc("salary"));         //highest salary display first */
		
		//projection
		//total row count
		//criteria.setProjection(Projections.rowCount());    //
		session.getTransaction().commit();
		return criteria.list();
		
	}

	@Override
	public List<Integer> getDistinctSalary() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.between("salary",5000,30000));
		criteria.setProjection(Projections.distinct(Projections.property("salary")));
		return criteria.list();
		//return EmployeeDao.super.getDistinctSalary();
	}


}

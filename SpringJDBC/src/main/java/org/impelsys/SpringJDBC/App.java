package org.impelsys.SpringJDBC;

import org.impelsys.data.impl.EmployeeDaoImpl;
import org.impelsys.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args){

    	System.out.println( "**Hello World**" );
        ApplicationContext appContext=new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDaoImpl employeeDao=(EmployeeDaoImpl) appContext.getBean("employeeDao");
        Employee emp=employeeDao.getEmployee(42);
        System.out.println("emp: " +emp);
    }
}

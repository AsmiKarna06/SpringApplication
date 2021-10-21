package org.impelsys.SpringAnnotationsDemo;

import org.impelsys.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	Car myCar= (Car) applicationcontext.getBean("audi");
        System.out.println( "Hello World!" );
        System.out.println( "Car :" + myCar.getType() +" has engine of type :" + myCar.getModel());
        
      
        
        
    }
}

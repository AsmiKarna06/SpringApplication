package org.impelsys.AutoWiringUsingComponent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car=(Car) applicationContext.getBean("car");
    	System.out.println( "Hello World!" );
        
    }
}

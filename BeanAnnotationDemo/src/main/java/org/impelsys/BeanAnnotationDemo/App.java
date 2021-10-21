package org.impelsys.BeanAnnotationDemo;

import org.impelsys.config.AppConfig;
import org.impelsys.model.impl.SamsungMobile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
 //   	ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
//        SamsungMobile S8 =new SamsungMobile();
//    	SamsungMobile S8 =applicationContext.getBean(samsungMobile.class); //retrieve bean from Spring Context 
//    	SamsungMobile S8 =(SamsungMobile) applicationContext.getBean("samsungMobile");
    	
    	AbstractApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
    	applicationContext.registerShutdownHook();
    	
//    	System.out.println("lazily loading the Samsung Mobile");
    	SamsungMobile S8 =(SamsungMobile) applicationContext.getBean("createSamsungPhone");
    	S8.config();
    }
}

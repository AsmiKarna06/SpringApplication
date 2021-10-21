package org.impelsys.model.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.impelsys.model.Mobile;
import org.impelsys.model.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component("samsungGalaxy")

public class SamsungMobile implements Mobile {

	@Autowired
	//@Qualifier("octaCoreProcessor8")  //should always write in camelcase
	Processor createQuadraCoreProcessor;
	
	
	public SamsungMobile(){
		System.out.println("In constructor");
	}
	
	public void config() {
		System.out.println("Quadra Core,12 Mbps Camera,8 GB Ram");
		createQuadraCoreProcessor.config();
	}

	//init method		//initialization activities are done
	@PostConstruct
	public void init()
	{
		System.out.println("initializing the samsungMobile");
	}
	
	//destroy method - all the shutdown activities are done
	@PreDestroy
	public void destroyMethod()
	{
		System.out.println("doing cleaning before the samsungMobile is destoyed");
	}
}
package org.impelsys.model.impl;

import org.impelsys.model.Processor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("coreProcessor8")
//@Primary
public class OctaCoreProcessor implements Processor {

	
	public OctaCoreProcessor()
	{
		System.out.println("Constructing QuadCoreProcessor");
	}
	public void config() {
		System.out.println("I am an OctaCoreprocessor");
	}

}

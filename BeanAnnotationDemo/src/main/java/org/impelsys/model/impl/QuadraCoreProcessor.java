package org.impelsys.model.impl;

import org.impelsys.model.Processor;
import org.springframework.stereotype.Component;

@Component
public class QuadraCoreProcessor implements Processor {

	public QuadraCoreProcessor()
	{
		System.out.println("Constructing QuadCoreProcessor");
	}
	
	public void config() {
		System.out.println("This is a QuadraCoreProcessor");
	}

}

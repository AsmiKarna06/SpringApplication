package org.impelsys.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:engine.properties")
public class Engine 
{
	@Value("type")
	String engineType;
	//Factory method
	//@Bean
	Engine getEngine()
	{
		return this;
	}
	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
}

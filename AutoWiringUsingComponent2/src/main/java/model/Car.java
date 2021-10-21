package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car 
{
	String type;
	String model;
	
	public Car()
	{
		System.out.println("Creating bean Car");
	}
	public String getType() {
		return type;
	}
	@Autowired
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	@Autowired
	public void setModel(String model) {
		this.model = model;
		System.out.println("Setter Model");
	}
}

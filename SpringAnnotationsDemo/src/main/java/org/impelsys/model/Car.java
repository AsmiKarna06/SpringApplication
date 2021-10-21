package org.impelsys.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
@PropertySource("classpath:car.properties")
public class Car //about the class Car we have put annotation called @bean
{
	@Value("type1")
	String type;
	
	@Value("model1")
	String model;
	@Autowired
//	@Qualifier("mustangEngine")  //which exact bean will be wired
	Engine mustangEngine;
	//@Bean 		//it is method level annotation not class
	
	
	@Autowired //constructor injection
	Car(@Qualifier("fordEngine")Engine e)
	{
		System.out.println("In construtor");
		mustangEngine=e;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	//@Required
	public void setModel(String model) {
		this.model = model;
	}


	public Engine getMustangEngine() {
		return mustangEngine;
	}

//	@Autowired
//	@Qualifier("mustangEngine")
	@Resource
	public void setMustangEngine(Engine mustangEngine) {
		this.mustangEngine = mustangEngine;
	}
}

package beans;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
    public BeanB(){
        System.out.println("Creating bean BeanB");
    }
}
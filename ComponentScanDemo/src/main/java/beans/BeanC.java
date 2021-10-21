package beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC {
    public BeanC(){
        System.out.println("Creating bean BeanC");
    }
}

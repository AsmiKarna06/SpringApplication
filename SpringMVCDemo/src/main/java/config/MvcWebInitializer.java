package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{	
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses(){
		return new Class[] {MvcConfig.class};
	}
	
	@Override
	protected String[] getServletMappings(){     
		return new String[]{"/"};
	}
}

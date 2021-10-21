package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller{
//	public ModelAndView validateUser(HttpServletRequest request){
//		System.out.println("In Login Controller");
//		return null;
//	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
}

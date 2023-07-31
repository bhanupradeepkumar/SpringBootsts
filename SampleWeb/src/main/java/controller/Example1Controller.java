package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

public class Example1Controller implements Controller {

	
	public Example1Controller() {
		System.out.println("Example1Controller() ctor...");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		System.out.println("handleRequest() invoked...");
		
		View view = new InternalResourceView("example1.jsp");
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("message", "Welcome to Spring MVC");
		return mav;
	}
}

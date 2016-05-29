package com.ajitesh.sh.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControllers {
	
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@RequestMapping(path="showCount")
	public ModelAndView showCountofLogin(ModelMap model){
		count++;
		System.out.println(" count is : " + count);
		model.addAttribute("count", count);
		return new ModelAndView("showCount",model)  ;
	}
	
	@RequestMapping(path="showView")
	public ModelAndView showView(ModelMap model){
		count++;
		System.out.println(" count is : " + count);
		model.addAttribute("count", count);
		return new ModelAndView("showCount",model)  ;
	}

}

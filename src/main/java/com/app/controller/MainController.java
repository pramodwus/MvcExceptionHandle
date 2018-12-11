package com.app.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.exception.CustomException;

@Controller
public class MainController {

	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type)
		throws Exception
	{
		System.out.println("======="+type);
	  if ("pramod".equals(type)) 
	  {
		// go handleCustomException
		  System.out.println("======="+type);
		throw new CustomException("E888", "This is custom message");
	  } else if ("io-error".equals(type))
	  {
		// go handleAllException
		throw new IOException();
	  } else {
		return new ModelAndView("index").addObject("msg", type);
	  }

	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) 
	{

		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) 
	{

		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}

}
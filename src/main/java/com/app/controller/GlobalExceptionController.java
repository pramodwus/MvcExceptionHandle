package com.app.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.app.exception.CustomException;

@ControllerAdvice
public class GlobalExceptionController
{

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

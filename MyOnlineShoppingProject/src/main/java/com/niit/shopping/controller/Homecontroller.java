package com.niit.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.dao.CategoryDao;
import com.niit.shopping.model.Category;

@Controller 

public class Homecontroller {
	@Autowired
	CategoryDao categoryDao;

@RequestMapping("/home")
public ModelAndView Home(){
	 List<Category> list=categoryDao.getAllCatagory();
	    return new ModelAndView("Home","categoryList",list);  
}
@RequestMapping("/index")
public ModelAndView index(){
	 List<Category> list=categoryDao.getAllCatagory();
	    return new ModelAndView("Home","categoryList",list);  
}
@RequestMapping("/Register")
public ModelAndView Register(){
	ModelAndView Register=new ModelAndView("Register");
	return Register;
}

@RequestMapping("/CartDetails")
public ModelAndView CartDetails(){
	ModelAndView CartDetails=new ModelAndView("CartDetails");
	return CartDetails;
}
@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
public ModelAndView loginPage() {

	return new ModelAndView("loginPage");
}

}

package com.example.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.persistence.model.Category;
import com.example.service.ICategoryService;

@Controller
@SessionAttributes("categoryList")
public class CategoryController {

	@Autowired
	ICategoryService categoryService;

	@RequestMapping(value = "/addCategory.htm", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView mv = new ModelAndView("admin/test/category");
		Category category = new Category();
		mv.addObject("category", category);
		List<Category> categoryList = categoryService.findAll();
		mv.addObject("categoryList", categoryList);
		return mv;
	}

	@RequestMapping(value = "/addCategory.htm", method = RequestMethod.POST)
	public ModelAndView processAddCategory(@ModelAttribute("category") Category category, BindingResult errors) {
		System.out.println("Category id = " + category.getCategoryId() + " " + category.getCategoryName());
		categoryService.create(category);
		List<Category> categoryList = categoryService.findAll();
		ModelAndView mv = new ModelAndView("admin/test/category");
		mv.addObject("categoryList", categoryList);
		return mv;
	}

	public String removeCategory() {
		return null;
	}

	public void findCategory() {

	}

	public void findAllCategories() {

	}

}

class Test implements Serializable{
	
}
class abc{
	
	 public static void main(String[] args) {
		 HashMap hm = new HashMap();
		hm.put("x",new Test());
	}
}
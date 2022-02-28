package com.atguigu.springmvc.crud.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	
	//查询数据
	@RequestMapping(value="/emps")
	public String getEmps(Model model){
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps",all);
		return "list";
	}	
	
	//添加数据
	@RequestMapping(value="/toaddempquick")
	public String addquickemp(@RequestParam("empinfo")Employee employee){
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}	
	

	//删除
		@RequestMapping(value="/emps/{id}",method=RequestMethod.DELETE)
		public String deleterequest(@PathVariable("id")Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
		}
	
}

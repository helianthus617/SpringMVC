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
	
	//新增数据时页面回显信息
	@RequestMapping("/toaddemp")
	public String toAddPage(Model model){
		model.addAttribute("depts",departmentDao.getDepartments());
		model.addAttribute("employee",new Employee());
		return "add";
	}
	//提交新增的数据
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	public String AddEmps(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	 //执行 update 方法之前调用 @RequestParam(value="id" 获取表单内的id
	 //表单没有lastName, 让lastName 有值
	@ModelAttribute
	public void MyModelAttribute(@RequestParam(value="id",required=false) Integer id,Model model){
		//任何路径转发都会调用  MyModelAttribute 
		//如果不处理if判断 添加就会出错,如果是添加操作时候,隐含对象的employee是null,
		//不将请求中的数据绑定进来
	if(id!=null){
		Employee employee = employeeDao.get(id);
		model.addAttribute("employee",employee);
	}
	}
	//页面显示数据回显
	@RequestMapping("/emps/{id}")
	public String getEmp(@PathVariable("id")Integer id,Model model){
		Employee employee = employeeDao.get(id);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("employee",employee);
		model.addAttribute("depts",departments);
		return "edit";
	}
	//提交更新数据
		@RequestMapping(value="/emps/{id}",method=RequestMethod.PUT)
		public String update(Employee employee){
		System.out.println("数据更新为"+employee);
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

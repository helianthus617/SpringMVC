package com.atguigu.springmvc.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;
/*
 * 知识点1//日期格式化
@DateTimeFormat(pattern="yyyy-MM-dd")
知识点2//JSR303做数据校验
JSR303规范 由Hibernate Validator 是该规范的实现
	第一步导入校验框架包
hibernate-validator-annotation-processor-5.0.0.CR2.jar
hibernate-validator-5.0.0.CR2.jar
validation-api-1.1.0.CR1.jar
jboss-logging-3.1.1.GA.jar
classmate-0.8.0.jar
第二步给JAVAbean加上校验注解
@Length(min=6,max=18)
@NotEmpty
第三步告诉javabean这个对象需要校验
public String AddEmps(@Valid Employee employee){
第四步获取校验结果,在校验对象的参数后面添加BingdingResult这个对象
 * 知识点2//国际化显示错误信息
 * 错误消息提示:Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'birthDay'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type java.lang.String to type @org.springframework.format.annotation.DateTimeFormat @javax.validation.constraints.Past java.util.Date for value '2021/11/11'; nested exception is java.lang.IllegalArgumentException: Unable to parse '2021/11/11'
错误字段:birthDay
Field error in object 'employee' on field 'birthDay': rejected value [2021/11/11]; codes [typeMismatch.employee.birthDay,typeMismatch.birthDay,typeMismatch.java.util.Date,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.birthDay,birthDay]; arguments []; default message [birthDay]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'birthDay'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type java.lang.String to type @org.springframework.format.annotation.DateTimeFormat @javax.validation.constraints.Past java.util.Date for value '2021/11/11'; nested exception is java.lang.IllegalArgumentException: Unable to parse '2021/11/11']
======================
错误消息提示:长度需要在5和18之间
错误字段:lastName
Field error in object 'employee' on field 'lastName': rejected value [啊啊啊]; codes [Length.employee.lastName,Length.lastName,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.lastName,lastName]; arguments []; default message [lastName],18,5]; default message [长度需要在5和18之间]
======================
错误消息提示:Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'birthDay'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type java.lang.String to type @org.springframework.format.annotation.DateTimeFormat @javax.validation.constraints.Past java.util.Date for value '2021/11/11'; nested exception is java.lang.IllegalArgumentException: Unable to parse '2021/11/11'
错误字段:birthDay
Field error in object 'employee' on field 'birthDay': rejected value [2021/11/11]; codes [typeMismatch.employee.birthDay,typeMismatch.birthDay,typeMismatch.java.util.Date,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.birthDay,birthDay]; arguments []; default message [birthDay]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'birthDay'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type java.lang.String to type @org.springframework.format.annotation.DateTimeFormat @javax.validation.constraints.Past java.util.Date for value '2021/11/11'; nested exception is java.lang.IllegalArgumentException: Unable to parse '2021/11/11']
======================
错误消息提示:不是一个合法的电子邮件地址
错误字段:email
Field error in object 'employee' on field 'email': rejected value [啊啊啊]; codes [Email.employee.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@36f9053a,.*]; default message [不是一个合法的电子邮件地址]
======================
错误消息提示:长度需要在5和18之间
错误字段:lastName
Field error in object 'employee' on field 'lastName': rejected value [啊啊啊]; codes [Length.employee.lastName,Length.lastName,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.lastName,lastName]; arguments []; default message [lastName],18,5]; default message [长度需要在5和18之间]
======================
codes [ 精确优先~
Email.employee.email,校验规则.隐藏模型中对象的key对象的属性
Email.email,校验规则.属性名
Email.java.lang.String,校验规则.属性类型
Email
]; 
第一步 配置国际化文件
第二步 在xml中让spring管理国际化资源文件
<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
<property name="basename" value="errors"></property>
第三步 页面取值<form:errors path="lastName"/><br/>
国际化细节:
1.显示参数:Length.java.lang.String=length incorrect , must between {2} and {1} !~~
知识点3//直接标注解显示错误信息
@NotEmpty(message="格式错了")
 * */
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
	//方式一 配合 <form:input path="LastName"/><form:errors path="LastName"/> 使用
//	@RequestMapping(value="/emps",method=RequestMethod.POST)
//	public String AddEmps(@Valid Employee employee,BindingResult result){
//		boolean hasErrors = result.hasErrors();
//		System.out.println("是否发生了校验错误 "+hasErrors);
//		if(hasErrors){
//			return "add";
//		}
//		
//		System.out.println("新增加的员工信息"+employee);
//		employeeDao.save(employee);
//		return "redirect:/emps";
//	}
//	方式二 //提交新增的数据${errorInfos.email}
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	public String AddEmps(@Valid Employee employee,BindingResult result,Model model){
		boolean hasErrors = result.hasErrors();
		if(hasErrors){
			List<FieldError> fieldErrors = result.getFieldErrors();
			Map<String,Object> errorsMap=new HashMap<String,Object>();
			for(FieldError fieldError:fieldErrors){
				System.out.println("错误消息提示:"+fieldError.getDefaultMessage());
				System.out.println("错误字段:"+fieldError.getField());
				System.out.println(fieldError);
				System.out.println("======================");
				errorsMap.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			model.addAttribute("errorInfos",errorsMap);	
			
			return "add";
		}
		System.out.println("新增加的员工信息"+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	

	
	//更新页面显示数据回显 
	@RequestMapping("/emps/{id}")
	public String getEmp(@PathVariable("id")Integer id,Model model){
		Employee employee = employeeDao.get(id);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("employee",employee);
		model.addAttribute("depts",departments);
		return "edit";
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
		System.out.println("employee的值是    "+employee);
		model.addAttribute("employee",employee);
	}
	}
	
	//更新
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

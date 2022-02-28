package com.atguigu.springmvc.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.entities.Employee;

//需要将MyStringToEmployeeConverter 加入到Converterservice中
//需要将webdatabinder设置成我们加了自定义类型转换器的Converterservice
public class MyConverter  implements Converter<String, Employee>{
	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	public Employee convert(String arg0) {
		System.out.println("得到的字符串是"+arg0);
		Employee em =new Employee();
		if(arg0.contains("-")){
		String[] split = arg0.split("-");
			em.setLastName(split[0]);
			em.setEmail(split[1]);
			em.setGender(Integer.parseInt(split[2]));
			em.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
		}
		return em;
	}
}
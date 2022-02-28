package com.atguigu.springmvc.crud.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

//知识点4 测试ajax
//jackson-annotations-2.1.5
//jackson-core-2.1.5
//jackson-databind-2.1.5
@Controller
public class DownloadTestController {
	/*
下载文件测试
	 * */
	@RequestMapping("/download")
	public 	ResponseEntity<byte[]> download(HttpServletRequest  request) throws Exception{
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/scripts/jquery-1.9.1.min.js");
		FileInputStream fileInputStream = new FileInputStream(realPath);
		byte[] temp=new byte[fileInputStream.available()];
		fileInputStream.read(temp);
		fileInputStream.close();
		
		
		HttpHeaders headers = new HttpHeaders() ;
		headers.set("Content-Disposition", "attachment;filename="+"jquery-1.9.1.min.js");
		HttpStatus status = null;
		return  new ResponseEntity<byte[]>(temp,headers,status.OK);
		

	}

	
	
}

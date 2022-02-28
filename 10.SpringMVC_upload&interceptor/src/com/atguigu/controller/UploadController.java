package com.atguigu.controller;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {
	//单文件上传
	@RequestMapping("/upload")
	public String testupload(
			@RequestParam(value="username",required=false)String username,
			@RequestParam(value="headerimg")MultipartFile  file) throws Exception{
		System.out.println("file.getName()"+file.getName());
		System.out.println("file.getOriginalFilename()"+file.getOriginalFilename());
		file.transferTo(new File("C:\\Users\\25420\\Desktop\\"+file.getOriginalFilename()));
		return "forward:/index.jsp";
	}
	
	
	//多文件上传
		@RequestMapping("/upload1")
		public String testupload1(
				@RequestParam(value="username",required=false)String username,
				@RequestParam(value="headerimg")MultipartFile[]  file) throws Exception{
				for(MultipartFile f1:file){
					if(!f1.isEmpty()){
						System.out.println("file.getName()"+f1.getName());
						System.out.println("file.getOriginalFilename()"+f1.getOriginalFilename());
						f1.transferTo(new File("C:\\Users\\25420\\Desktop\\"+f1.getOriginalFilename()));						
					}	
				}
			
		
			return "forward:/index.jsp";
		}
}

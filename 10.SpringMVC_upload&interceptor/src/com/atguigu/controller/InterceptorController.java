package com.atguigu.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//拦截器使用
/*第一步 使用类来继承interceptor 接口
 *第二步  xml配置拦截器拦截路径
 * 
 * 单拦截器的执行流程
 * 拦截器的prehandle---目标方法----拦截器posthandle---页面----拦截器的aftercompletion
 * 细节1,只要prehandle不放行,就没有后续的流程
 * 细节2,目标方法抛出异常,prehandle---目标方法----页面----拦截器的aftercompletion
 * 多拦截器
preHandle1
preHandle
testintercepter1控制器输出
postHandle
postHandle1
success.jsp 输出
afterCompletion
afterCompletion1
测试myintercepter不放行
preHandle1
preHandle
afterCompletion1
 * */
@Controller
public class InterceptorController {
	@RequestMapping("/testintercepter1")
	public String testupload(){
		System.out.println("testintercepter1控制器输出");
		return "success";
	}

}

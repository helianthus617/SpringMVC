# Experiment of SpringMVC

&nbsp; &nbsp;  实验环境:(spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32   eclipse-jee-kepler-SR2-win32)<br/>
&nbsp; &nbsp;  Spring版本:spring-framework-4.0.0.RELEASE-dist.<br/>
&nbsp; &nbsp;  实验中用到的源码解析流程https://helianthus617.github.io/SpringMVC/.<br/>
**1.SpringMVC_01** <br/>
&nbsp; &nbsp; Helloworld <br/>
&nbsp; &nbsp; @PathVariable,@RequestParam注解使用<br/>
&nbsp; &nbsp; 表单处理乱码(请求乱码/相应乱码，GET/POST方式) <br/>
&nbsp; &nbsp;原始API使用，HttpServletRequest request,HttpSession session<br/> 
&nbsp; &nbsp;ant风格url地址访问(URL地址可以写模糊的通配符)<br/>
&nbsp; &nbsp;访问服务器限定请求参数eg:params={"username"}  发送请求时携带 username参数 <br/>
**2.SpringMVC_rest** <br/>
&nbsp; &nbsp;表单使用REST架构风格 <br/>
**3.SpringMVC_output 模型数据 重点** <br/>
&nbsp; &nbsp;类上标注@SessionAttributes(value={"msg7"})<br/>
&nbsp; &nbsp;方法参数位置 Map<String,String> map , Model model,  ModelMap modelmap @ModelAttribute<br/>
&nbsp; &nbsp;方法上标注 @ModelAttribute<br/>
&nbsp; &nbsp;new ModelAndView()<br/>
**4.SpringMVC_Jump** <br/>
&nbsp; &nbsp;forward/redirect使用<br/>
**5.SpringMVC_JSTL** <br/>
&nbsp; &nbsp;国际化表单的使用<br/>
&nbsp; &nbsp;程序获取国际化信息<br/>
**6.SpringMVC_view_reslover** <br/>
&nbsp; &nbsp;自定义视图解析器<br/>
**7.SpringMVC_CRUD 重点** <br/>
&nbsp; &nbsp;CRUD的深入使用包含对@ModelAttribute注解使用<br/>
**8.SpringMVC_databinder** <br/>
自定义提交表单数据的类型绑定<br/>
**9.SpringMVC_format&validate&message 国际化/格式化/校验器** <br/>
&nbsp; &nbsp;AJAX<br/>
&nbsp; &nbsp;使用HttpEntity 拿到请求头数据<br/>
&nbsp; &nbsp;表单校验页面回显，国际化回显需要设置错误码<br/>
&nbsp; &nbsp;@ResponseBody注解配合jackson包的使用返回json格式的返回体<br/>
&nbsp; &nbsp;前端提交json格式数据,@requestbody注解将数据自动封装为对象<br/>
&nbsp; &nbsp;使用ResponseEntity 可以自定义 响应头,响应体,状态--->下载文件测试<br/>
**10.SpringMVC_upload&interceptor** <br/>
&nbsp; &nbsp;文件上传<br/>
&nbsp; &nbsp;拦截器分析<br/>
**11.SpringMVC_LocalResolver** <br/>
&nbsp; &nbsp;使用超链接切换国际化SessionLocaleResolver的使用<br/>
**12.SpringMVC_Exception** <br/>
&nbsp; &nbsp;异常处理<br/>


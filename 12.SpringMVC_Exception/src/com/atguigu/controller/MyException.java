package com.atguigu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="出现异常",value=HttpStatus.NOT_EXTENDED)
public class MyException extends RuntimeException {
	   static final long serialVersionUID = -7334892190745766939L;

}

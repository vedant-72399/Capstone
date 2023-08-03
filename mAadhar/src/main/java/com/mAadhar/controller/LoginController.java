package com.mAadhar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mAadhar.bean.Login;
import com.mAadhar.service.LoginService;




@RestController
@RequestMapping("login")
@CrossOrigin(origins="*")
public class LoginController {
	@Autowired
	LoginService loginService;
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int signIn(@RequestBody Login login) {
		String value=loginService.signIn(login);
		int flag;
		if(value!=null) {
			flag=1;
		}
		else {
			flag=0;
		}
		return flag;

	}
	@PostMapping(value ="signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		System.out.println(login);
		return loginService.signUp(login);
	}
}

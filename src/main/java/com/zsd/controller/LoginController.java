package com.zsd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsd.util.JwtHelper;
@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
    private JwtHelper jwtHelper;
	@RequestMapping("/login")
	public Map<String,Object> login(HttpServletRequest request){
		String username = request.getParameter("username");
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> claims = new HashMap<String, Object>();
		if ("001".equals(username)||"002".equals(username)) {
			claims.put("username", username);
			if ("001".equals(username)) {
				claims.put("role", "admin");
			}else{
				claims.put("role", "noAdmin");
			}
			String token=jwtHelper.generateToken(claims);
			map.put("key", token);
			map.put("res", "success");
		}else{
			map.put("res", "error");
		}
		
		
		return map;
	}
	@RequestMapping("/getdate")
	public Map<String,String> getdate(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("data", "getdate");
		map.put("res", "success");
		return map;
	}
	@RequestMapping("/go")
	public void go(){
		System.out.println("+++++++++++++go");
	}
}

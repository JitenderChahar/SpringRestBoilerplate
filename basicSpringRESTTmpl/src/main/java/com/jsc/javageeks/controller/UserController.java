package com.jsc.javageeks.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsc.javageeks.exception.NotAuthenticateException;

@RestController
@RequestMapping("/user")
public class UserController {

	// -------------------Retrieve All Users

	@RequestMapping(value = "/testApi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String testApi() throws NotAuthenticateException {
		String str = "exception";
		if(str.equalsIgnoreCase("exception"))
			throw new NotAuthenticateException("not authenticate");
		return "This api is working fine";
	}

}

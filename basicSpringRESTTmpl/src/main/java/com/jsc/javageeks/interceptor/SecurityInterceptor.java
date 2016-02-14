package com.jsc.javageeks.interceptor;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jsc.javageeks.exception.NotAuthenticateException;
import com.jsc.javageeks.utils.Util;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out
				.println("------------------Inside BasicAuthInterceptor-----------------------");
		
		Util util = new Util();
		
		String authHeader = request.getHeader(AUTHORIZATION_HEADER_KEY);
		Base64 base64 = new Base64();
		if (authHeader != null && authHeader.length() > 0) {
			String authToken = authHeader;
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedToken = new String(
					base64.decode(authToken.getBytes()));
			StringTokenizer tokenizer = new StringTokenizer(decodedToken, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if (username.equals(util.getProperty("service.access.user"))
					&& password.equals(util
							.getProperty("service.access.password"))) {
				return true;
			}
		}

		throw new NotAuthenticateException(
				"User not autherise to access this API");
	}
}

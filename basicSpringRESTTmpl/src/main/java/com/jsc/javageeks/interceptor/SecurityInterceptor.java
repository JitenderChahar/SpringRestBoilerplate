package com.jsc.javageeks.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	//private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	//private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out
				.println("------------------Inside BasicAuthInterceptor-----------------------");
/*
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
			if ("user".equals(username) && "password".equals(password)) {
				return true;
			}
		}*/

		/*
		 * ErrorMessage errorMessage = new ErrorMessage("error",
		 * "user not atuniticated"); ObjectMapper mapper = new ObjectMapper();
		 * String jsonInString = mapper.writeValueAsString(errorMessage);
		 * response.getOutputStream().write(jsonInString.getBytes());
		 */
		/*throw new NotAuthenticateException(
				"User not autherise to access this API");*/
		return true;
	}
}

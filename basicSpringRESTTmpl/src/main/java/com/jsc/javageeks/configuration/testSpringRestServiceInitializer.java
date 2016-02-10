package com.jsc.javageeks.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.jsc.javageeks.filter.SimpleCORSFilter;

public class testSpringRestServiceInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(testSpringRestServiceConfiguration.class);
		javax.servlet.FilterRegistration.Dynamic corsFilter = container.addFilter("simpleCORSFilter",
				SimpleCORSFilter.class);
		corsFilter.addMappingForUrlPatterns(null, true, "/*");
		container.addListener(new ContextLoaderListener(appContext));
		appContext.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(appContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/webapi/*");
	}

}

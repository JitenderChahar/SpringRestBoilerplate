package com.jsc.javageeks.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jsc.javageeks.filter.SimpleCORSFilter;

/*public class testSpringRestServiceInitializer implements WebApplicationInitializer  {

 public void onStartup(ServletContext container) throws ServletException {

 // Create the 'root' Spring application context
 AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
 appContext.register(testSpringRestServiceConfiguration.class);

 //Adding cors filters
 javax.servlet.FilterRegistration.Dynamic corsFilter = container.addFilter("simpleCORSFilter",
 SimpleCORSFilter.class);
 corsFilter.addMappingForUrlPatterns(null, true, "/*");

 // Manage the lifecycle of the root application context
 container.addListener(new ContextLoaderListener(appContext));
 appContext.setServletContext(container);

 // Register and map the dispatcher servlet
 ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(appContext));
 servlet.setLoadOnStartup(1);
 servlet.addMapping("/webapi/*");
 }

 }
 */

public class testSpringRestServiceInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		javax.servlet.FilterRegistration.Dynamic corsFilter = servletContext
				.addFilter("simpleCORSFilter", SimpleCORSFilter.class);
		corsFilter.addMappingForUrlPatterns(null, true, "/*");
		super.onStartup(servletContext);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { testSpringRestServiceConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/webapi/*" };
	}

	@Override
	public void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

}
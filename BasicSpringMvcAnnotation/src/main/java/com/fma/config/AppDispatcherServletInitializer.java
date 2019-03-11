package com.fma.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.fma.initializer.RootApplicationConfig;
import com.fma.initializer.WebMVCConfig;

public class AppDispatcherServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootApplicationContext=null;
		AnnotationConfigWebApplicationContext appServletContext=null;
		DispatcherServlet dispatcherServlet=null;
		ContextLoaderListener contextLoaderListener=null;
		
	rootApplicationContext= new AnnotationConfigWebApplicationContext();
	rootApplicationContext.register(RootApplicationConfig.class);
contextLoaderListener= new ContextLoaderListener(rootApplicationContext);
  servletContext.addListener(contextLoaderListener);
		
		
appServletContext=new AnnotationConfigWebApplicationContext();
appServletContext.register(WebMVCConfig.class);
dispatcherServlet= new DispatcherServlet(appServletContext);
ServletRegistration.Dynamic config=servletContext.addServlet("dispatcher",dispatcherServlet);
config.addMapping("*.htm");
config.setLoadOnStartup(2);		
	}
	
	

}

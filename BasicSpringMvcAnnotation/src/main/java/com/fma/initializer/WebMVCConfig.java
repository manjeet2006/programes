package com.fma.initializer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMVCConfig {
	
	@Bean
	public HandlerMapping handlerMapping() {
		SimpleUrlHandlerMapping handlerMapping = null;
		/*Properties props = null;
		props = new Properties();
		props.put("/first-mvc.htm", "fpvc");*/
		
		Map<String,String>  urlMap=null;
		urlMap= new HashMap<>();
		urlMap.put("/first-mvc.htm", "fpvc");
		handlerMapping = new SimpleUrlHandlerMapping();

		handlerMapping.setUrlMap(urlMap);

		return handlerMapping;
	}
      @Bean("fpvc")
	public Controller controller() {
		ParameterizableViewController parameterizableViewController = null;
		parameterizableViewController = new ParameterizableViewController();

		parameterizableViewController.setViewName("first-mvc-annotation");

		return parameterizableViewController;
	}
   @Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = null;
		internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

}

package com.tracker;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppInitialize extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class,JPAConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		//return new Class<?>[0];
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
	return new String[]{"/api/*"};
	}

}

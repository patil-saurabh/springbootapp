package com.saurabh.sfguru.SpringBootApp.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

@Component
public class BeanLifeCycleDemoBean implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ServletConfigAware, 
						ServletContextAware, InitializingBean, DisposableBean, ApplicationContextAware {

	private int counter = 0;
	
	@Override
	public void setBeanName(String arg0) {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		System.out.println("**** "+ ++counter +" setBeanClassLoader() method called ."+arg0.toString()+" *** ");
		
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");
		
	}

	@Override
	public void setServletConfig(ServletConfig arg0) {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("**** "+ ++counter +" Setting BeanName in setBeanName() method. *** ");		
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("***** "+ ++counter +" PostConstruct method called. ");		
	}
	
	@javax.annotation.PreDestroy
	public void PreDestroy(){
		System.out.println("***** "+ ++counter +" PreDestroy method called. ");
	}
	
	
}

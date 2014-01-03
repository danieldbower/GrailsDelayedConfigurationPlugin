package com.infinum.grails.plugins.delayedconfiguration

import grails.spring.BeanBuilder

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.spring.GrailsApplicationContext
import org.springframework.context.ApplicationContext


/**
 * Handles configuring the application for local use, dynamically generating the 
 * spring beans necessary.  This class merely handles managing the lifecycle of
 * the configuration.  It checks to see if the application has been configured, 
 * and initiates configuration, and kills existing beans when a new configuration 
 * comes in.  The implementation of the IDelayedConfiguration class will contain
 * the actual bean creation logic
 * 
 * It will provide access to beans in the already existing/running grails context
 * for the newly instantiated beans, but existing beans will only be able to get 
 * access to the delayedConfiguration beans by going through the 
 * DelayedConfigurationMgmtService.bean(String beanName) method.
 *
 */
class DelayedConfigurationMgmtService {
	
	GrailsApplication grailsApplication
	
	IDelayedConfiguration delayedConfiguration
	
	private GrailsApplicationContext localSpringContext

	/**
	 * We lose out on having Grails dependency inject these beans into our other 
	 * services, so they'll have to access through this service.
	 */
	Object bean(String beanName){
		return localSpringContext.getBean(beanName)
	}
	
	/**
	 * We can manually kick off reconfiguration of the beans here.
	 * The existing delayed config beans are destroyed and recreated.
	 */
	void configure(){
		if(!delayedConfiguration){
			log.info("No IDelayedConfiguration bean detected, not configuring")
			return
		}
		
		reset()

		//create the local spring context
		BeanBuilder builder = new BeanBuilder(grailsApplication.mainContext)
		
		delayedConfiguration.configure(builder, grailsApplication.config)
		
		localSpringContext = builder.createApplicationContext()
	}

	boolean isConfigured(){
		return localSpringContext
	}
	
	Date getLastSuccessfulConfigDate(){
		Long startupDateStamp = localSpringContext?.startupDate
		
		if(startupDateStamp){
			return new Date(startupDateStamp)
		}
		return null
	}

	void reset(){
		if(localSpringContext){
			//kill each bean we created
			localSpringContext.close()
		}
	}

	/**
	 * This is run by DelayedConfigurationPluginBootStrap to initialize the 
	 * Delayed Config at startup
	 */
	void bootConfig(){
		log.info("Initializing DelayedConfiguration Beans")
		configure()
	}
}

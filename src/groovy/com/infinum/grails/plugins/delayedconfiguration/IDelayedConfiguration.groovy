package com.infinum.grails.plugins.delayedconfiguration

import grails.spring.BeanBuilder

import org.springframework.context.ApplicationContext


interface IDelayedConfiguration {
	
	void configure(BeanBuilder builder, Map config)
	
}

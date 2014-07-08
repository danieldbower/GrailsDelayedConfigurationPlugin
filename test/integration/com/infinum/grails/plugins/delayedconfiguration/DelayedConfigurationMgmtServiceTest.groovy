package com.infinum.grails.plugins.delayedconfiguration

import org.junit.Test

class DelayedConfigurationMgmtServiceTest {

	
	DelayedConfigurationMgmtService delayedConfigurationMgmtService
	
	@Test
	void isConfigured(){
		assert ! delayedConfigurationMgmtService.isConfigured()
	}
}

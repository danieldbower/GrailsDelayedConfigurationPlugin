import com.infinum.grails.plugins.delayedconfiguration.DelayedConfigurationMgmtService


class DelayedConfigurationPluginBootStrap {

	DelayedConfigurationMgmtService delayedConfigurationMgmtService
	
	def init = { 
		delayedConfigurationMgmtService.bootConfig()
	}
	
	def destroy = {
		
	}
}

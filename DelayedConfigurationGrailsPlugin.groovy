class DelayedConfigurationGrailsPlugin {
    // the plugin version
    def version = "0.3"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Delayed Configuration Plugin" // Headline display name of the plugin
    def author = "Daniel Bower"
    def authorEmail = "daniel.bower@infinum.com"
    def description = '''\
If you need some beans to be instantiated only when a user of your application 
turns on some certain functionality, you can do so here.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/delayed-configuration"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Infinum LLC", url: "http://infinum.com" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Alex Leader", email: "alexander.leader@infinum.com" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/infinumllc/delayedConfiguration" ]

}

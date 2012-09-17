//import org.codehaus.groovy.grails.commons.ApplicationAttributes
//import event.EventListeners

class BootStrap {

    def init = { servletContext ->
//        def atrnom = ApplicationAttributes.APPLICATION_CONTEXT
//        def appctx = servletContext.getAttribute(atrnom)
//        def config = appctx.getBean('&sessionFactory')
//        def lstnrs = EventListeners.auditListeners()
//        config.hibernateEventListeners = lstnrs
    }
    
    def destroy = {
    }
}

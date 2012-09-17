package event

import org.codehaus.groovy.grails.orm.hibernate.HibernateEventListeners

class EventListeners {
        
    public static HibernateEventListeners auditListeners() {
        def lstnrsmap = new HashMap()
        lstnrsmap.put('pre-nsert', new event.PreInsertHandler())
        lstnrsmap.put('pre-update', new event.PreUpdateHandler())
        lstnrsmap.put('post-insert', new event.PostInsertHandler())
        lstnrsmap.put('post-update', new event.PostUpdateHandler())
    
        def listeners = new HibernateEventListeners()
        listeners.listenerMap = lstnrsmap
        return listeners
    }
    
}


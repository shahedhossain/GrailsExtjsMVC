package event

import org.hibernate.HibernateException
import org.hibernate.event.PreUpdateEvent
import org.hibernate.event.PreUpdateEventListener

class PreUpdateHandler implements PreUpdateEventListener {
	
    public boolean onPreUpdate(final PreUpdateEvent event) {		
	try {
            def model = event.getEntity()
            def audit = model.audit
            audit.reviseUser = 1
            audit.reviseDate = new Date()
        } catch (HibernateException e) {
            println e.printStackTrace()
        }
        return false;
    }
}

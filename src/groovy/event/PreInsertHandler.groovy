package event

import org.hibernate.HibernateException
import org.hibernate.event.PreInsertEvent
import org.hibernate.event.PreInsertEventListener

class PreInsertHandler implements PreInsertEventListener {
	
    public boolean onPreInsert(final PreInsertEvent event) {		
	try {
            def model = event.getEntity()
            def audit = model.audit
            audit.entryUser = 1
            audit.entryDate = new Date()
        } catch (HibernateException e) {
            println e.printStackTrace()
        }
        return false;
    }
}


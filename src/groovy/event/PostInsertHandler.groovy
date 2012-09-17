package event

import org.hibernate.HibernateException
import org.hibernate.event.PostInsertEvent
import org.hibernate.event.PostInsertEventListener

class PostInsertHandler implements PostInsertEventListener {
    
    public void onPostInsert(final PostInsertEvent event) {
        try {
            def model = event.getEntity()
            def audit = model.audit
            def user = audit.entryUser
            def date = audit.entryDate
            println "POST INSERT => ENTERER: ${user} ENTERED: ${date}"
        } catch (HibernateException e) {
            println e.printStackTrace()
        }
        return;
    }
	
}


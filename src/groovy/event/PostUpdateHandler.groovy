package event

import org.hibernate.HibernateException
import org.hibernate.event.PostUpdateEvent
import org.hibernate.event.PostUpdateEventListener

class PostUpdateHandler implements PostUpdateEventListener {
	
    public void onPostUpdate(final PostUpdateEvent event) {
        try {
            def model = event.getEntity()
            def audit = model.audit
            def user = audit.reviseUser
            def date = audit.reviseDate
            println "POST UPDATE => REVISE: ${user} REVISED: ${date}"
        } catch (HibernateException e) {
            println e.printStackTrace()
        }
        return;
    }
    
}


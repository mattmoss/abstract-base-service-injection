package demo.injection


import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractBaseService {

    @Autowired
    SessionFactory sessionFactory

    protected void flushSession() {
        sessionFactory.currentSession.flush()
    }

    protected void deleteItems(List<String> itemsToDelete) {
        Item.where {
            name in itemsToDelete
        }
    }
}

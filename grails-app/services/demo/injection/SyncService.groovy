package demo.injection


import grails.gorm.transactions.Transactional

//@GrailsCompileStatic
@Transactional
class SyncService extends AbstractBaseService {

    def sync(List<String> itemsToDelete) {
        deleteItems(itemsToDelete)
        flushSession()
    }

}

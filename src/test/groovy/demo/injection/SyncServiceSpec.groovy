package demo.injection

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class SyncServiceSpec extends Specification
        implements ServiceUnitTest<SyncService>, DataTest {

    def setup() {
        mockDomain Item, [
                [name: 'alpha', desc: 'first' ],
                [name: 'beta',  desc: 'second'],
                [name: 'gamma', desc: 'last'  ],
        ]
    }

    def 'test that an empty names-to-delete list results in no deletions'() {
        when:
        service.deleteItems([])

        then:
        Item.count == 3
    }
}

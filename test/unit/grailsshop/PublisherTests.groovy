package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Publisher)
class PublisherTests {

    void testValidation() {
        def publisher = new Publisher()
        println publisher

        publisher.name = null
        assert publisher.validate() == false

        publisher.name = ''
        assert publisher.validate() == false

        publisher.name = 'オライリー'
        assert publisher.validate() == true
    }
}

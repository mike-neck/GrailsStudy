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
        def objects = []
        objects << 'name'

        publisher.name = null
        assert publisher.validate(objects) == false

        publisher.name = ''
        assert publisher.validate(objects) == false

        publisher.name = 'オライリー'
        assert publisher.validate(objects) == true
    }

    @Test
    void persistence() {
        assert Publisher.count() == 0
        assert Book.getCount() == 0
    }

}

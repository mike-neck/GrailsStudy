package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Customer)
class CustomerTests {

    @Test
    void validateName() {
        mockForConstraintsTests(Customer)
        def object = 'name'

        def customer = new Customer()
        assert customer.validate() == false
        assert customer.errors[object] == 'nullable'

        customer = new Customer(name: '')
        assert customer.validate() == false
        assert customer.errors[object] == 'blank'
    }
}

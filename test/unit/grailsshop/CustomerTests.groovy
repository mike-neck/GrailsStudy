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

    @Test
    void validateAddress() {
        mockForConstraintsTests(Customer)
        def object = 'address'

        def customer = new Customer()
        assert customer.validate() == false
        assert customer.errors[object] == 'nullable'

        customer = new Customer(address: '')
        assert customer.validate() == false
        assert customer.errors[object] == 'blank'
    }

    @Test
    void validatePhoneNumber() {
        mockForConstraintsTests(Customer)
        def object = 'phoneNumber'

        def customer = new Customer()
        assert customer.validate() == false
        assert customer.errors[object] == 'nullable'

        customer = new Customer(phoneNumber: '')
        assert customer.validate() == false
        assert customer.errors[object] == 'blank'

        customer = new Customer(phoneNumber: 'abcjhkdjs')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(phoneNumber: '0')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(phoneNumber: '-0-1')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(phoneNumber: '00-000-')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(phoneNumber: '0-0')
        assert customer.validate() == false
        assert customer.errors[object] == null
    }
}

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

    @Test
    void validateEMail() {
        mockForConstraintsTests(Customer)
        def object = 'eMail'

        def customer = new Customer()
        assert customer.validate() == false
        assert customer.errors[object] == 'nullable'

        customer = new Customer(eMail: '')
        assert customer.validate() == false
        assert customer.errors[object] == 'blank'

        customer = new Customer(eMail: 'abc')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(eMail: '1b@a.c')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(eMail: 'ab1@a.x')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(eMail: 'a-b@1a.x')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(eMail: 'a-b.c@a.1')
        assert customer.validate() == false
        assert customer.errors[object] == 'matches'

        customer = new Customer(eMail: 'a-b.c_d@a.1.e')
        assert customer.validate() == false
        assert customer.errors[object] == null
    }
}

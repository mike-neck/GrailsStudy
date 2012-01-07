package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Order)
class OrderTests {

    @Ignore
    @Test
    void validateDetails() {
        mockForConstraintsTests(Order)
        def object = 'orderDetails'
        def order = new Order()

        assert order.validate() == false
        assert order.errors[object] == 'nullable'
    }

    @Test
    void validateDate() {
        mockForConstraintsTests(Order)
        def object = 'date'

        def order = new Order()
        assert order.validate() == false
        assert order.errors[object] == 'nullable'

        order = new Order(date: tomorrow())
        assert order.validate() == false
        assert order.errors[object] == 'max'

        order = new Order(date: yesterday())
        assert order.validate() == false
        assert order.errors[object] == null
    }

    @Test
    void validateCustomer() {
        mockForConstraintsTests(Order)
        def object = 'customer'

        def order = new Order()
        assert order.validate() == false
        assert order.errors[object] == 'nullable'
    }

    def tomorrow = {
        def cal = Calendar.getInstance(TimeZone.getTimeZone('Asia/Tokyo'))
        cal.add(Calendar.DATE, 1)
        return cal.getTime()
    }

    def yesterday = {
        def cal = Calendar.getInstance(TimeZone.getTimeZone('Asia/Tokyo'))
        cal.add(Calendar.DATE, -1)
        return cal.getTime()
    }
}

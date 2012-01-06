package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(OrderDetail)
class OrderDetailTests {

    @Ignore
    @Test
    void validateQuantity() {
        def orderDetail = new OrderDetail()
        def object = 'quantity'

        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == 'min'
    }

    @Test
    void successCase() {
        def order = new Order(date: new Date())
        def book = new Book()
        def orderDetail = new OrderDetail(order: order, book: book, quantity: 1)

        assert orderDetail.validate() == true
    }
    
}

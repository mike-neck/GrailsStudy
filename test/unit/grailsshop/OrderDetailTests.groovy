package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(OrderDetail)
class OrderDetailTests {

    Order order

    Book book

    @Before
    void setUp() {
        order = new Order(date: new Date(2012, 1, 1))
        book = new Book()
    }

    @Test
    void validateQuantity() {
        mockForConstraintsTests(OrderDetail)
        def object = 'quantity'

        def orderDetail = new OrderDetail(order: order, book: book, quantity: 0)
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == 'min'

        orderDetail = new OrderDetail(quantity: 1)
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == null
    }

    @Test
    void validateRelation () {
        mockForConstraintsTests(OrderDetail)
        def object = 'book'

        def orderDetail = new OrderDetail(order: order, quantity: 1)
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == 'nullable'

        orderDetail = new OrderDetail(book: book)
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == null

        object = 'order'
        orderDetail = new OrderDetail()
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == 'nullable'

        orderDetail = new OrderDetail(order: order)
        assert orderDetail.validate() == false
        assert orderDetail.errors[object] == null
    }

    @Test
    void successCase() {
        mockForConstraintsTests(OrderDetail)
        def orderDetail = new OrderDetail(order: order, book: book, quantity: 1)

        assert orderDetail.validate() == true
    }
    
}

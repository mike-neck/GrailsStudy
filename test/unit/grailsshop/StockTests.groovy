package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Stock)
class StockTests {

    @Test
    void validateBook() {
        mockForConstraintsTests(Stock)
        def object = 'book'

        def stock = new Stock()
        assert stock.validate() == false
        assert stock.errors[object] == 'nullable'

        def book = new Book()
        stock = new Stock(book: book)
        stock.validate()
        assert stock.errors[object] == null
    }
}

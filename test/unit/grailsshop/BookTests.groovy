package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookTests {

    def newBook = {
        return new Book(
                title: 'test title',
                author: 'mike',
                price: 200,
                releaseDate: new Date(),
                isbn13: '1234567890123',
                description: 'text'
        )
    }

    @Test
    void useMockForConstraint() {
        def existingBook = new Book(
                title: 'test title',
                author: 'mike',
                price: 200,
                releaseDate: new Date(),
                isbn13: '1234567890123',
                description: 'text'
        )
        mockForConstraintsTests(Book, [existingBook])

        def book = new Book()
        assert book.validate() == false
    }

    void testValidationTitle() {
        def book = new Book()

        book.title = null
        def object = 'title'
        assert book.validate([object]) == false

        book.title = ''
        assert book.validate([object]) == false

        book.title = createTextToTheSize(200)
        assert book.validate([object]) == true

        book.title = createTextToTheSize(201)
        assert book.validate([object]) == false
    }

    void testValidationAuthor() {
        def book = new Book()

        book.author = null
        def object = 'author'
        assert book.validate([object]) == false

        book.author = ''
        assert book.validate([object]) == false

        book.author = createTextToTheSize(1)
        assert book.validate([object]) == true

        book.author = createTextToTheSize(255)
        assert book.validate([object]) == true

        book.author = createTextToTheSize(256)
        assert book.validate([object]) == false
    }

    void testValidationPrice() {
        def book = new Book()
        
        book.price = -1
        def object = 'price'
        assert book.validate([object]) == false

        book.price = 0
        assert book.validate([object]) == true

        book.price = 1200
        assert book.validate([object]) == true
    }

    void testValidationReleaseDate() {
        def book = new Book()
        
        book.releaseDate = null
        def object = 'releaseDate'
        assert book.validate([object]) == true
    }

    void testValidationIsbn13() {
        def book = new Book()
        
        book.isbn13 = null
        def object = 'isbn13'
        assert book.validate([object]) == false

        book.isbn13 = ''
        assert book.validate([object]) == false

        book.isbn13 = '1234567890123'
        assert book.validate([object]) == true

        book.isbn13 = createTextToTheSize(13)
        assert book.validate([object]) == false

        book.isbn13 = '123456789012'
        assert book.validate([object]) == false

        book.isbn13 = '12345678901234'
        assert book.validate([object]) == false
    }

    @Test
    void validationImageUrl() {
        def book = new Book()
        
        book.imageUrl = null
        def object = 'imageUrl'
        assert book.validate([object]) == false
    }

    def createTextToTheSize = {int size ->
        def text = []
        size.times {
            text << 'a'
        }
        text.join('')
    }
}

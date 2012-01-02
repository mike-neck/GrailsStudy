package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookTests {

    def existingBook = {
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
    void validationNoAttributes() {
        mockForConstraintsTests(Book, [existingBook()])

        def book = new Book()
        assert book.validate() == false
    }

    @Test
    void validateTitle() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'title'

        def book = new Book()
        assert book.validate() == false
        assert book.errors[object] == 'nullable'

        book = new Book(title: '')
        assert book.validate() == false
        assert book.errors[object] == 'blank'

        book = new Book(title: createTextToTheSize(200))
        assert book.validate() == false
        assert book.errors[object] == null

        book = new Book(title: createTextToTheSize(201))
        assert book.validate() == false
        assert book.errors[object] == 'maxSize'
    }

    @Test
    void validateAuthor() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'author'

        def book = new Book()
        book.author = null
        assert book.validate() == false
        assert book.errors[object] == 'nullable'

        book = new Book(author: '')
        assert book.validate() == false
        assert book.errors[object] == 'blank'

        book = new Book(author: createTextToTheSize(1))
        assert book.validate() == false
        assert book.errors[object] == null

        book = new Book(author: createTextToTheSize(255))
        assert book.validate() == false
        assert book.errors[object] == null

        book = new Book(author: createTextToTheSize(256))
        assert book.validate() == false
        assert book.errors[object] == 'maxSize'
    }

    @Test
    void validatePrice() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'price'

        def book = new Book(price: -1)
        assert book.validate() == false
        assert book.errors[object] == 'min'

        book = new Book(price: 0)
        assert book.validate() == false
        assert book.errors[object] == null

        book = new Book(price: 1200)
        assert book.validate() == false
        assert book.errors[object] == null
    }

    @Test
    void validateReleaseDate() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'releaseDate'

        def book = new Book()
        assert book.validate() == false
        assert book.errors[object] == null
    }

    @Test
    void validateIsbn13() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'isbn13'

        def book = new Book()
        assert book.validate() == false
        assert book.errors[object] == 'nullable'

        book = new Book(isbn13: '')
        assert book.validate() == false
        assert book.errors[object] == 'blank'

        book = new Book(isbn13: '1234567890123')
        assert book.validate() == false
        assert book.errors[object] == 'unique'

        book = new Book(isbn13: createTextToTheSize(13))
        assert book.validate() == false
        assert book.errors[object] == 'matches'

        book = new Book(isbn13: '123456789012')
        assert book.validate() == false
        assert book.errors[object] == 'matches'

        book = new Book(isbn13: '12345678901234')
        assert book.validate() == false
        assert book.errors[object] == 'matches'

        book = new Book(isbn13: '9876543210123')
        assert book.validate() == false
        assert book.errors[object] == null
    }

    @Test
    void validateImageUrl() {
        mockForConstraintsTests(Book, [existingBook()])
        def object = 'imageUrl'

        def book = new Book()
        assert book.validate() == false
        assert book.errors[object] == null
    }

    def createTextToTheSize = {int size ->
        def text = []
        size.times {
            text << 'a'
        }
        text.join('')
    }
}

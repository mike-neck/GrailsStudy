package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Publisher)
@Mock([Publisher, Book])
class PublisherTests {

    @Test
    void validateName() {
        mockForConstraintsTests(Publisher, existingPublisher())
        def object = 'name'

        def publisher = new Publisher()
        assert publisher.validate() == false
        assert publisher.errors[object] == 'nullable'

        publisher = new Publisher(name: '')
        assert publisher.validate() == false
        assert publisher.errors[object] == 'blank'

        publisher = new Publisher(name: 'オライリー')
        assert publisher.validate() == true
    }

    @Test
    void persistence() {
        assert Publisher.count() == 0
        assert Book.getCount() == 0

        def publisher = new Publisher(name: '翔泳社')
        def book = new Book(
                title: 'Grails 入門',
                author: 'mike_neck',
                price: 2000,
                releaseDate: createReleaseDate(2012, 1, 2),
                isbn13: '0123456789321',
                imageUrl: 'http://localhost:8080/image/img.png',
                description: 'dummy test book.'
        )
        publisher.addToBooks(book).save()

        assert Publisher.count() == 1

        publisher.delete()

        assert Publisher.count() == 0
    }

    def existingPublisher = {
        [new Publisher(name: '岩波書店')]
    }

    Date createReleaseDate(int year, int month, int date) {
        def cal = Calendar.getInstance(TimeZone.getTimeZone('Asia/Tokyo'))
        cal.set(year, month, date)
        cal.getTime()
    }
}

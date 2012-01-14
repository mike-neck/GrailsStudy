package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Shipment)
class ShipmentTests {

    @Test
    void validateDate() {
        mockForConstraintsTests(Shipment)
        def object = 'date'

        def shipment = new Shipment()
        assert shipment.validate() == false
        assert shipment.errors[object] == 'nullable'

        shipment = new Shipment(date: dayFromToday(1))
        assert shipment.validate() == false
        assert shipment.errors[object] == 'max'

        shipment = new Shipment(date: dayFromToday(0))
        shipment.validate()
        assert shipment.errors[object] == null
    }

    @Test
    void validateOrder() {
        mockForConstraintsTests(Shipment)
        def object = 'order'

        def shipment = new Shipment()
        assert shipment.validate() == false
        assert shipment.errors[object] == 'nullable'
    }

    @Test
    void testDate() {
        assert dayFromToday(0).compareTo(dayFromToday(1)) < 0
        assert dayFromToday(0).compareTo(dayFromToday(-1)) > 0
    }

    def dayFromToday = {int d ->
        def cal = Calendar.getInstance(TimeZone.getTimeZone('Asia/Tokyo'))
        getDate(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DATE) + d)
    }

    def getDate = { int y, int m, int d ->
        def cal = Calendar.getInstance(TimeZone.getTimeZone('Asia/Tokyo'))
        cal.set(y, m, d, 0, 0)
        cal.getTime()
    }
}

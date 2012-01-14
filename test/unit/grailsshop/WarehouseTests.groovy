package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Warehouse)
class WarehouseTests {

    @Test
    void validateAddress() {
        mockForConstraintsTests(Warehouse)
        def object = 'address'

        def warehouse = new Warehouse()
        assert warehouse.validate() == false
        assert warehouse.errors[object] == 'nullable'

        warehouse = new Warehouse(address: '')
        assert warehouse.validate() == false
        assert warehouse.errors[object] == 'blank'
    }

    @Test
    void validatePhoneNumber() {
        mockForConstraintsTests(Warehouse)
        def object = 'phoneNumber'

        def warehouse = new Warehouse()
        assert warehouse.validate() == false
        assert warehouse.errors[object] == 'nullable'

        warehouse = new Warehouse(phoneNumber: '')
        assert warehouse.validate() == false
        assert warehouse.errors[object] == 'blank'

        warehouse = new Warehouse(phoneNumber: 'aaa-bbb')
        assert warehouse.validate() == false
        assert warehouse.errors[object] == 'matches'

        warehouse = new Warehouse(phoneNumber: '00-00')
        warehouse.validate()
        assert warehouse.errors[object] == null
    }

    @Test
    void validateStocks() {
        assert Warehouse.count() == 0
        def warehouse = new Warehouse(address: 'アドレス', phoneNumber: '00-00-000')
        assert warehouse.stocks == null
    }
}

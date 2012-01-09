package grailsshop



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Account)
class AccountTests {

    @Test
    void validateName() {
        mockForConstraintsTests(Account)
        def object = 'name'

        def account = new Account()
        assert account.validate() == false
        assert account.errors[object] == 'nullable'

        account = new Account(name: '')
        assert account.validate() == false
        assert account.errors[object] == 'blank'

        account = new Account(name: 'A')
        assert account.validate() == false
        assert account.errors[object] == 'minSize'

        account = new Account(name: 'abcdef')
        account.validate()
        assert account.errors[object] == null

        account = new Account(name: '1bcdef')
        assert account.validate() == false
        assert account.errors[object] == 'matches'

        account = new Account(name: 'a-b-c-')
        account.validate()
        assert account.errors[object] == null
    }

    @Test
    void validatePassword() {
        mockForConstraintsTests(Account)
        def object = 'password'

        def account = new Account()
        assert account.validate() == false
        assert account.errors[object] == 'nullable'

        account = new Account(password: '')
        assert account.validate() == false
        assert account.errors[object] == 'blank'
    }

    @Test
    void validateUniqueUser() {
        mockForConstraintsTests(Account, [new Account(name: 'test-user', password: 'abcdefkees')])
        def object = 'name'

        def account = new Account(name: 'test-user', password: 'a123245sdfkjl')
        assert account.validate() == false
        assert account.errors[object] == 'unique'
    }
}

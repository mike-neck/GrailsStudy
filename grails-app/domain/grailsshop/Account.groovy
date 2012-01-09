package grailsshop

class Account {

    /**
     * Customer.
     */
    Customer customer

    /**
     * 名前.
     */
    String name

    /**
     * パスワード.
     * TODO これは暗号化とかしなくていいんか？
     */
    String password

    static constraints = {
        customer(nullable: true)
        name(blank: false, minSize: 6, matches: /^[a-zA-Z]([a-zA-Z0-9-_]+)/, unique: true)
        password(blank: false)
    }
}

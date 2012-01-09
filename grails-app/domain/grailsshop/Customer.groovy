package grailsshop

class Customer {

    /**
     * 名前.
     */
    String name

    /**
     * 住所.
     */
    String address

    static constraints = {
        name(blank: false)
        address(blank: false)
    }
}

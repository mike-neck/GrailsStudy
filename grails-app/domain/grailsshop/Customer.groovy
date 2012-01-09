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

    /**
     * 電話番号.
     */
    String phoneNumber

    static constraints = {
        name(blank: false)
        address(blank: false)
        phoneNumber(blank: false, matches: /^[0-9]+[0-9\-]+[0-9]+$/)
    }
}

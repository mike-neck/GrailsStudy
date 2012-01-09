package grailsshop

class Warehouse {

    /**
     * 住所.
     */
    String address

    /**
     * 電話番号.
     */
    String phoneNumber

    static constraints = {
        address(blank: false)
        phoneNumber(blank: false, matches: /^[0-9]+[0-9\-]+[0-9]+$/)
    }
}

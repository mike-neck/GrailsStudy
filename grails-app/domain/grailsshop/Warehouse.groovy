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

    /**
     * 在庫.
     */
    static hasMany = [stocks : Stock]

    static constraints = {
        address(blank: false)
        phoneNumber(blank: false, matches: /^[0-9]+[0-9\-]+[0-9]+$/)
    }
}

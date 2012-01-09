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

    /**
     * e-mailアドレス.
     */
    String eMail

    /**
     * 支払い方法.
     */
    String paymentMethod

    static constraints = {
        name(blank: false)
        address(blank: false)
        phoneNumber(blank: false, matches: /^[0-9]+[0-9\-]+[0-9]+$/)
        eMail(blank: false, matches: /^[a-zA-Z][a-zA-Z0-9\-\._]*[a-zA-Z]+@[a-zA-Z][a-zA-Z0-9\-\._]*[a-zA-Z]+$/)
        paymentMethod(blank: false)
    }
}

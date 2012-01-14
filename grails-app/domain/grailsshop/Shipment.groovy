package grailsshop

class Shipment {

    /**
     * 出荷日付.
     */
    Date date

    static constraints = {
        date(max: new Date())
    }
}

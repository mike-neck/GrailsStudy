package grailsshop

class Shipment {

    /**
     * 出荷日付.
     */
    Date date

    static belongsTo = [
            /**
             * 発注.
             */
            order : Order
    ]

    static constraints = {
        date(max: new Date())
    }
}

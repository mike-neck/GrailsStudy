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
            order : Order,

            /**
             * 倉庫.
             */
            warehouse : Warehouse
    ]

    static constraints = {
        date(max: new Date())
    }
}

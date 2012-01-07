package grailsshop

class Order {

    /**
     * 受注日.
     */
    Date date

    /**
     * 受注詳細.
     */
    static hasMany = [orderDetails: OrderDetail]

    static constraints = {
        date(nullable: false, max: new Date())
        orderDetails(minSize: 1)
    }

    static mapping = {
        table('`order`')
        id(generator: 'sequence', params: [sequence : 'order_id_seq'])
    }
}

package grailsshop

class OrderDetail {

    /**
     * 注文.
     * 購入書籍.
     */
    static belongsTo = [order : Order, book : Book]

    /**
     * 購入数量.
     */
    int quantity

    static constraints = {
        quantity(min: 1)
    }
}

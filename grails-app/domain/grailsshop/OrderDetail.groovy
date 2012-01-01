package grailsshop

class OrderDetail {

    /**
     * 購入モデル.
     */
    static belongsTo = [order : Order]

    /**
     * 購入書籍.
     */
    Book book

    /**
     * 購入数量.
     */
    int quantity

    static constraints = {
        book(nullable: false)
        quantity(min: 1)
    }
}

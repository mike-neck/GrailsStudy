package grailsshop

class Stock {

    /**
     * 書籍.
     */
    static belongsTo = [book: Book]

    /**
     * 在庫数
     */
    int quantity

    static constraints = {
    }
}

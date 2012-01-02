package grailsshop

class Publisher {

    /**
     * 出版社名.
     */
    String name

    /**
     * 出版している書籍.
     */
    static hasMany = [books: Book]

    static constraints = {
        name(blank: false, unique: true)
        books(minSize: 0)
    }
}

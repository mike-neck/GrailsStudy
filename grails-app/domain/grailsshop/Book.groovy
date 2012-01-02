package grailsshop

/**
 * 書籍モデル.
 */
class Book {

    /**
     * 出版社.
     */
    static belongsTo = [publisher: Publisher]

    /**
     * タイトル.
     */
    String title

    /**
     * 著者.
     */
    String author

    /**
     * 価格.
     */
    int price

    /**
     * 出版年月日.
     */
    Date releaseDate

    /**
     * ISBN.
     */
    String isbn13

    /**
     * 本の画像URL.
     */
    String imageUrl

    /**
     * 紹介.
     */
    String description

    static constraints = {
        title(blank: false, maxSize: 200)
        author(blank: false, maxSize: 255)
        price(min: 0)
        releaseDate(nullable: true)
        isbn13(blank: false, matches: "\\p{Digit}{13}", unique: true)
    }

    static mapping = {
        id(generator: 'sequence', params: [sequence: 'book_id_sequence'])
        description(type: 'text')
    }
}

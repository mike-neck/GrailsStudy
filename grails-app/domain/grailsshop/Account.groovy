package grailsshop

class Account {

    /**
     * 名前.
     */
    String name

    /**
     * パスワード.
     * TODO これは暗号化とかしなくていいんか？
     */
    String password

    static constraints = {
        name(blank: false, minSize: 6, matches: /^[a-zA-Z]([a-zA-Z0-9-_]+)/, unique: true)
        password(blank: false)
    }
}

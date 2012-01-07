package grailsshop

class Account {

    /**
     * 名前.
     */
    String name

    static constraints = {
        name(blank: false, minSize: 6, matches: /^[a-zA-Z]([a-zA-Z0-9-_]+)/)
    }
}

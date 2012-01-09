package grailsshop

class Customer {

    /**
     * 名前.
     */
    String name

    static constraints = {
        name(blank: false)
    }
}

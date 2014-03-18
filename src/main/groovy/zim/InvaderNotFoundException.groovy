package zim

class InvaderNotFoundException extends RuntimeException {
    InvaderNotFoundException(String name) {
        super("Invader not found: $name")
    }
}

class Weapons(val name: String, var damageInflicted: Int,) {
    override fun toString(): String {
        return "$name inflicted $damageInflicted damage!"
    }
}
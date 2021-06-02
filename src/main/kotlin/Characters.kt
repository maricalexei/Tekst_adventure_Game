open class Characters (val name: String, var hitpoints: Int) {
    open fun takeDamage(damage: Int){
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0){
            hitpoints = remainingHitpoints
            println("$name took $damage points of damage and has $hitpoints hitpoints left.")
        } else {
            if (hitpoints > 0) {
                println("$name is dead")
            } else {
                println("$name has $remainingHitpoints left.")
            }
        }
    }
    override fun toString(): String {
        return "Name: $name,Hitpoints: $hitpoints"
    }
}
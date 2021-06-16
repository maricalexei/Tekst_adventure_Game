open class Characters (val name: String, var hitpoints: Int) {
    open fun takeDamage(damage: Int){
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0){
            println("$name took $damage points of damage and has $hitpoints hitpoints left.")
        } else {
            if (remainingHitpoints <= 0) {
                println("$name took $damage points of damage and is dead")
            } else {
                println("$name has $remainingHitpoints left.")
            }
        }
        hitpoints = remainingHitpoints
    }
    override fun toString(): String {
        return "Name: $name, Hitpoints: $hitpoints"
    }

    open fun attack(character: Characters, minDamage: Int, maxDamage: Int){
        val attackDamage = (minDamage..maxDamage).random()
        character.takeDamage(attackDamage)
        Thread.sleep(1000)
    }
}
open class Characters (val name: String, var hitpoints: Int) {

    val ANSI_RESET = "\u001B[0m"
    val ANSI_BLACK = "\u001B[30m"
    val ANSI_RED = "\u001B[31m"
    val ANSI_GREEN = "\u001B[32m"
    val ANSI_YELLOW = "\u001B[33m"
    val ANSI_BLUE = "\u001B[34m"
    val ANSI_PURPLE = "\u001B[35m"
    val ANSI_CYAN = "\u001B[36m"
    val ANSI_WHITE = "\u001B[37m"

    open fun takeDamage(damage: Int){
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0){
            ANSI_RED
            println("$name took $damage points of damage and has $hitpoints hitpoints left.")
            ANSI_RESET
        } else {
            if (remainingHitpoints <= 0) {
                ANSI_RED
                println("$name took $damage points of damage and is dead")
                ANSI_RESET
            } else {
                ANSI_RED
                println("$name has $remainingHitpoints left.")
                ANSI_RESET
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
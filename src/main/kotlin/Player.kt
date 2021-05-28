import kotlin.io.println as println

class Player(val name: String, var hitpoints: Int = 10, var level: Int = 1, var radiation: Int = 0) {
    var weapon = Weapons("Fists", damageInflicted = 1,)

    fun show() {
        if (hitpoints < 0) {
            println("$name is dead")
        } else {
            println("$name is alive")
        }
    }

    override fun toString(): String {
        return """
            name:  $name
            life:  $hitpoints
            level: $level
            Rads: $radiation
            weapon: ${weapon.name}
            weapon damage: ${weapon.damageInflicted}
            """
    }
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
}
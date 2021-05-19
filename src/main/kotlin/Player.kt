import kotlin.io.println as println

class Player(val name: String, var health: Int = 3, var level: Int = 1, var radiation: Int = 1) {
    var weapon = Weapons("Fists", damageInflicted = 1,)

    fun show() {
        if (health < 0) {
            println("$name is dead")
        } else {
            println("$name is alive")
        }
    }

    override fun toString(): String {
        return """
            name:  $name
            life:  $health
            level: $level
            Rads: $radiation
            weapon: ${weapon.name}
            weapon damage: ${weapon.damageInflicted}
            """
    }
}
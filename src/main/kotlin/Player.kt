import kotlin.io.println as println

class Player(name: String, hitpoints: Int = 10, var level: Int = 1, var radiation: Int = 0) :
    Characters (name, hitpoints){
    var weapon = Weapons("Fists", 1, 2)

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
            Min-Damage: ${weapon.minDamage}
            Max-Damage: ${weapon.maxDamage}
            """
    }



}
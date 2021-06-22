import kotlin.io.println as println

class Player(name: String, override var maxHitpoints: Int = 10, var hitpoints: Int = maxHitpoints, var level: Int = 1, var radiation: Int = 0) :
    Characters (name, maxHitpoints){
    val inventory = ArrayList<Loot>()
    var weapon = Weapons("Fists", 1, 2)


    fun heal(healthAmount : Int){
        hitpoints += healthAmount
        if (hitpoints > maxHitpoints){
            hitpoints = maxHitpoints
        }
    }

    fun show() {
        if (hitpoints < 0) {
            println("$name is dead")
        } else {
            println("$name is alive")
        }

    }

    override fun takeDamage(damage: Int) {
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0){
            ANSI_RED
            println("$name took $damage points of damage and has $remainingHitpoints hitpoints left.")
            ANSI_RESET
        } else {
            if (remainingHitpoints <= 0) {
                ANSI_RED
                println("$name took $damage points of damage and is dead")
                died()
                ANSI_RESET
            } else {
                ANSI_RED
                println("$name has $remainingHitpoints left.")
                ANSI_RESET
            }
        }
        hitpoints = remainingHitpoints
    }

   fun levelUp(){
       level ++
       maxHitpoints += 2
       heal(maxHitpoints)
       weapon.minDamage = weapon.minDamage + level
       weapon.maxDamage = weapon.maxDamage + level * 2

   }


    override fun toString(): String {

        return """
            $ANSI_GREEN
            name:  $name
            life:  $hitpoints out of $maxHitpoints
            level: $level
            Rads: $radiation
            weapon: ${weapon.name}
            Min-Damage: ${weapon.minDamage}
            Max-Damage: ${weapon.maxDamage}
            $ANSI_RESET
            """

    }



}
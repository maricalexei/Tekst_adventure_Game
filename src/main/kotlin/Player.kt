import kotlin.io.println as println

class Player(name: String, var maxHitpoints: Int = 10, var level: Int = 1, var radiation: Int = 0) :
    Characters (name, maxHitpoints){
    var weapon = Weapons("Fists", 1, 2)

    var currentHitpoints = maxHitpoints


    fun heal(healthAmount : Int){
        currentHitpoints += healthAmount
        if (currentHitpoints > maxHitpoints){
            currentHitpoints = maxHitpoints
        }
    }

    fun show() {
        if (hitpoints < 0) {
            println("$name is dead")
        } else {
            println("$name is alive")
        }

    }

   fun levelUp(){
       level ++
       heal(maxHitpoints)
       maxHitpoints += 2
       weapon.minDamage = weapon.minDamage + level
       weapon.maxDamage = weapon.maxDamage + level * 2

   }


    override fun toString(): String {

        return """
            $ANSI_GREEN
            name:  $name
            life:  $hitpoints
            level: $level
            Rads: $radiation
            weapon: ${weapon.name}
            Min-Damage: ${weapon.minDamage}
            Max-Damage: ${weapon.maxDamage}
            $ANSI_RESET
            """

    }



}
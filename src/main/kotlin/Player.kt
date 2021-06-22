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
        println("$name has healed back to full health!")
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

    open fun superAttack(character: Characters, minDamage: Int, maxDamage: Int, minOdds: Int, maxOdds: Int){
        var damage = (minDamage..maxDamage).random()
        var Odds = (minOdds..maxOdds).random()
        when (Odds) {
            in 2..5 -> {
                println("You do some damage to him!")
                Thread.sleep(500)
                character.takeDamage(damage * 2)
            }
            6 -> {
                println("Critical Hit!!!")
                Thread.sleep(500)
                character.takeDamage(damage * 3)
            }
            else -> {
                println("You failed your attack :c")
                Thread.sleep(500)
                character.takeDamage(0)
            }
        }
    }

    open fun superBlock(minDamage: Int, maxDamage: Int, minOdds: Int, maxOdds: Int){
        var odds = (minOdds..maxOdds).random()
        var damage = (minDamage..maxDamage).random()
        when (odds) {
            in 2..5 -> {
                println("You managed to block some of his attack!")
                Thread.sleep(500)
                player.takeDamage(damage/2)
            }
            1 -> {
                println("You failed to block his attack!!")
                Thread.sleep(500)
                player.takeDamage(damage)
            }
            6 -> {
                println("He misses his attack!!")
                Thread.sleep(500)
                player.takeDamage(0)
            }
        }
    }

   fun levelUp(){
       level ++
       maxHitpoints += 2
       heal(maxHitpoints)
       weapon.minDamage = weapon.minDamage + level
       weapon.maxDamage = weapon.maxDamage + level * 2

       println("${ANSI_PURPLE}${name} has leveled up!\n" +
               "You are now level:$level!\n" +
               "Your min damage now is: ${weapon.minDamage}\n" +
               "Your max damage now is: ${weapon.maxDamage}\n" +
               "Your max Hitpoints now is: ${maxHitpoints}.")

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
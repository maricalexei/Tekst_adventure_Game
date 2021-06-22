class SuperMutantSuicider(name: String, maxHitpoints: Int,) : Enemy(name, maxHitpoints) {


    var counter = 1
    open fun explode() {

        if (counter == 0 || maxHitpoints == 0) {
            ANSI_RED
            println("He is ready to explode")
            player.takeDamage(100)
            maxHitpoints = 0
        } else {
            ANSI_RED
            println("The super mutant is comming towords you!")
        }
        counter -= 1
    }
}
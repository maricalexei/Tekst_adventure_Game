class Weapons(val name: String, var minDamage: Int, var maxDamage: Int) {

    open val damageInflicted = (minDamage..maxDamage).random()

}
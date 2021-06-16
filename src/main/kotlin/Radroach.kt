class Radroach(name: String, maxHitpoints: Int,) : Enemy(name, maxHitpoints){
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage * 2)
    }

}
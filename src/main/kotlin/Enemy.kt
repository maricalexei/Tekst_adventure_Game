open class Enemy(name: String, hitpoints: Int) : Characters(name, hitpoints) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
    }
}
enum class LootType {
    POTION, ARMOR, RING, OBJECT
}

class Loot(val name: String, val lootType: LootType, val value: Double){

    override fun toString(): String {
        return "$name is a $lootType type and is worth $value gold"
    }

}
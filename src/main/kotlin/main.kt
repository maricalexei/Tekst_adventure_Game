import java.sql.SQLOutput
import java.util.logging.Level
import kotlin.system.exitProcess

@OptIn(ExperimentalStdlibApi::class)

fun main(args: Array<String>) {
    level2()
}

val ANSI_RESET = "\u001B[0m"
val ANSI_BLACK = "\u001B[30m"
val ANSI_RED = "\u001B[31m"
val ANSI_GREEN = "\u001B[32m"
val ANSI_YELLOW = "\u001B[33m"
val ANSI_BLUE = "\u001B[34m"
val ANSI_PURPLE = "\u001B[35m"
val ANSI_CYAN = "\u001B[36m"
val ANSI_WHITE = "\u001B[37m"

var choice : String = ""
var osGameOver : String = ""

var player = Player("")

@OptIn(ExperimentalStdlibApi::class)
fun level1(){

    println("$ANSI_BLUE Welcome to the world  of Fallin.\nA postapocalyptic world set in the year 2377.")
    println("")
    Thread.sleep(2000)
    println("In the year 2077 the world is split into two factions who are at war with one another.")
    println("")
    Thread.sleep(3000)
    println("We have the W.E.S.T which is comprised of the Old world contents:\n" +
            "Europe, North and South America and Oceania.")
    println("")
    Thread.sleep(3000)
    println("We have the E.A.S.T. which is comprised of the Old world contents:\n" +
            "U.S.S.R., Turkey and Asia")
    println("")
    Thread.sleep(4000)
    println("The great war was started with the Old World country china declaring war against Europe,\n" +
            "when this happened China allied with all of the countries in Asia,\n" +
            "the Soviet Union and turkey and together they formed the E.A.S.T.")
    println("")
    Thread.sleep(5000)
    println("When China declared war against Europe,\n" +
            "Europe sought help from America and Oceania and they together formed the W.E.S.T.")
    println("")
    Thread.sleep(3000)
    println("Everyone was already prepared for the war and Vaults were build in preparation of the war.\n" +
            "As much of the civilian forces were commanded to take shelter in these vaults\n" +
            "to protect them from the nuclear war.")
    println("")
    Thread.sleep(4000)
    println("The world that we knew was destroyed and became a wasteland,\n" +
            "the only survivors had to make do with wat was left.\n" +
            "The vaults that were build pre war almost never opened,\n" +
            "and had no contact with the outside world. ")
    println("")
    Thread.sleep(5000)
    println("You are one of those people,\n" +
            "You are born in a vault,\n" +
            "You are expected to live in the vault\n" +
            "and die in the vault.")

    Thread.sleep(6000)
    println("------------------")

    println("$ANSI_GREEN Please Enter your name  $ANSI_RESET")

    var username = readLine()
    player = Player("$username")
    while (username!!.isBlank()) {
        println("$ANSI_RED enter a valid username $ANSI_RESET")
        username = readLine()
    }

    player.show()

    println("$ANSI_BLUE You are $ANSI_GREEN $username $ANSI_BLUE\n" +
            "You wake up in the vault on what seems like a normal day\n $ANSI_RESET")


    println("$ANSI_RED You spot a Radroach in your room!")
    Thread.sleep(1000)
    val radRoach = Radroach("Radroach", 5)
    println(radRoach)

    while(radRoach.maxHitpoints > 0) {
        println("What do you want to do?")
        Thread.sleep(500)
        println("Press 1 to attack")
        Thread.sleep(500)
        println("Press 2 to try to escape")

        choice = readLine().toString()

        if (radRoach.maxHitpoints > 0) {
            radRoach.attack(player, 1, 1)
        }

        when (choice) {
            "1" -> player.attack(radRoach, player.weapon.minDamage, player.weapon.maxDamage)
            "2" -> println("You fail to get away")
            else -> {
                println("No valid input detected ")
            }
        }
    }

    println(ANSI_GREEN)
    println(player)

    Thread.sleep(1000)
    println("$ANSI_BLUE")
    println("You hear some people talking in the commonroom,\n" +
            "and you decide to talk over to see whats going on.\n")
    Thread.sleep(1000)
    println("")
    println("When you arrive in the commonroom you are immediately taken to the front,\n" +
            "it seems the overseer of the vault has something to ask of you.")
    println("")
    println("Overseer:")
    println("* We need your help $username, it seems our vault is in danger, *\n" +
            "* the waterpurifier is in need of maintenance and we require a waterpurifier chip.*")
    Thread.sleep(500)
    println("")
    println("* The problem is that we dont have anything to repair it with in the vault, *\n" +
            "* we need someone to get out into the wasteland and find a waterchip for us before its too late. *")
    Thread.sleep(1000)
    println("")
    Thread.sleep(1000)
    println("* I'm asking you to go out into the wasteland and find us that waterchip,*\n " +
            "* With that chip our vault can be saved *")
    println("")
    Thread.sleep(1000)
    println("* Will you $ANSI_GREEN $username $ANSI_BLUE help the vault by going on this mission? *\n ")
    println("What do you say to his quest? $ANSI_YELLOW Yes $ANSI_RESET or $ANSI_YELLOW no $ANSI_RESET?")
    Thread.sleep(2000)
    osGameOver = readLine().toString().lowercase()

    when (osGameOver){
        "yes" -> level2()
        "no" -> gameOver1()

    }

}

fun gameOver1() {
    println("$ANSI_RED You have declined the mission of the overseer and the vault. \n" +
            "The vault is doomed and there is nothing you're going to do about it. \n" +
            "At somepoint the water starts turning green and glowing, its irratiated. \n" +
            "Everybody in the vault dies. \n \n" +
            "GameOver!")


}

fun level2(){
    println("$ANSI_BLUE You take the baseball bat from your room with you and \n " +
            "make your way to the vault entrance$ANSI_RESET")
    Thread.sleep(1000)
    val baseBallBat = Weapons ("BaseBall bat", 1, 10)
    Thread.sleep(1000)
    player.weapon = baseBallBat
    player.levelUp()
    println(player)
    Thread.sleep(5000)
    println("$ANSI_BLUE As you get to the vault entrance you see the overseer waiting for you \n" +
            "Overseer: \n" +
            "* Its important for the members of our vault that you comeback with that waterchip. *\n" +
            "* You need to make sure you find that chip and bring it back in time *")
    Thread.sleep(2000)
    println("I'm ready to go 'Press: 1'")
    Thread.sleep(500)
    println("Ask the overseer where to go 'Press: 2'")


    Thread.sleep(1000)
    choice = readLine().toString()
    when (choice) {
        "1"-> println("You tell the overseer that you will make sure you find the waterchip and bring it back")
        "2"-> getMap()
    }
    Thread.sleep(1000)
    println("The vault door opens for the first time after de bombs were dropped. \n" +
            "as the door opens, you are almost blinded from the sunlight of the wasteland. \n" +
            "You step outside, the door closes behind you and you are now outside.")
    Thread.sleep(3000)

    println("Do you go east north or west?")
    choice = readLine()?.toLowerCase().toString()
    val north = "north"
    val east = "east"
    val west = "west"

    while (choice != north || choice != east || choice != west) {

        when (choice) {
            "north" -> level2North()
            "east" -> level2East()
            "west" -> level2West()
        }
    }
    Thread.sleep(2000)




}

fun level2West(){
    println("level2west")
}

fun level2North(){
    println("level2north")
    println(
        "$ANSI_BLUE You take the baseball bat from your room with you and \n " +
                "make your way to the vault entrance$ANSI_RESET"
    )
    Thread.sleep(1000)
    val pistol = Weapons("Pistol", 5, 15)
    Thread.sleep(1000)
    player.weapon = pistol
    player.levelUp()
    println(player)
    Thread.sleep(5000)
    println(
        "$ANSI_BLUE As you enter the third stage you see no enemies in the distance \n" +
                "you see a pistol on the ground, you pick it up \n"
    )

    Thread.sleep(1000)
    choice = readLine().toString()
    when (choice) {
        "1" -> println("you keep walking")
        "2" -> println("You look on the map")
    }
    Thread.sleep(1000)
    println(
        "You are scared but not ready to give up you feel more determined then ever \n" +
                "The smell is something completely new to you. \n" +
                "you feel more powerful then ever!"
    )
    Thread.sleep(3000)

    println("Do you go east north or west?")
    choice = readLine()?.toLowerCase().toString()
    val north = "north"
    val east = "east"
    val west = "west"

    while (choice != north || choice != east || choice != west) {

        when (choice) {
            "north" -> level4North()
            "east" -> level3East()
        }
    }
    Thread.sleep(2000)
}


fun level4North(){
    println("level4north")
}

fun level3East() {
    println("level2east")
}




fun level2East(){
    println("level2east")
}

fun getMap(){
    println("$ANSI_BLUE You ask the overseer where you need to go and he hands you a map")
    val map = Loot("A old map of the wasteland", LootType.OBJECT, 0.0)
    player.inventory.add(map)
    println(map)
    println("You look at the map and know you need to go north first when you exit the vault")
}

fun died(){
    println("${ANSI_RED}You have died and lost the game $ANSI_RESET")
    exitProcess(1)
}

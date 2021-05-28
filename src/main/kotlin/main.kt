fun main(args: Array<String>) {
    println("Welcome to the world  of Fallin.\nA postapocalyptic world set in the year 2377.")
    println("")
    println("In the year 2077 the world is split into two factions who are at war with one another.")
    println("")
    println("We have the W.E.S.T which is comprised of the Old world contents:\n" +
            "Europe, North and South America and Oceania.")
    println("")
    println("We have the E.A.S.T. which is comprised of the Old world contents:\n" +
            "U.S.S.R., Turkey and Asia")
    println("")
    println("The great war was started with the Old World country china declaring war against Europe,\n" +
            "when this happened China allied with all of the countries in Asia,\n" +
            "the Soviet Union and turkey and together they formed the E.A.S.T.")
    println("")
    println("When China declared war against Europe,\n" +
            "Europe sought help from America and Oceania and they together formed the W.E.S.T.")
    println("")
    println("Everyone was already prepared for the war and Vaults were build in preparation of the war.\n" +
            "As much of the civilian forces were commanded to take shelter in these vaults\n" +
            "to protect them from the nuclear war.")
    println("")
    println("The world that we knew was destroyed and became a wasteland,\n" +
            "the only survivors had to make do with wat was left.\n" +
            "The vaults that were build pre war almost never opened,\n" +
            "and had no contact with the outside world. ")
    println("")
    println("You are one of those people,\n" +
            "You are born in a vault,\n" +
            "You are expected to live in the vault\n" +
            "and die in the vault.")

    println("------------------")
    println("Please Enter your name")

    var username = readLine()

    val player = Player("$username")

    while (username!!.isBlank()) {
        println("Please enter a valid username")
        username = readLine()
    }

    println("You are $username\n" +
            "You wake up in the vault on what seems like a normal day\n" +
            "")

    println("You spot a Radroach in your room!")

    val radRoach = Radroach("Radroach", 1)


    println(player)

}

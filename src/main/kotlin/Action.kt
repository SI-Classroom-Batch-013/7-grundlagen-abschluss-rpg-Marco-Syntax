open class Action {
    val zaubersprueche: MutableMap<String, Int> = mutableMapOf(
        "Reducto" to 50,
        "stupor" to 100,
        "Accio" to 150,
        "avada kedavra" to 300
    )

    open fun zauberSpruchAnwenden(zauberSpruchName: String): Int? {
        var zauberSpruchSchaden = zaubersprueche[zauberSpruchName]
        var versuche = 1

        while (zauberSpruchSchaden == null && versuche <= 3) {
            println("Bitte gib einen gültigen Zauberspruch ein: ")
            val benutzereingabe = readln()
            zauberSpruchSchaden = zaubersprueche[benutzereingabe]
            versuche++

            if (zauberSpruchSchaden == null && versuche <= 3) {
                println("Zauber: $benutzereingabe nicht gefunden. Versuch $versuche von 3.")
            }
        }
        if (zauberSpruchSchaden == null) {
            println("Drei Versuche wurden erreicht. Angriff wurde abgebrochen.")
        } else {
            println("Zauber: $zauberSpruchName, Schaden: $zauberSpruchSchaden hP")
        }
        return zauberSpruchSchaden
    }

}
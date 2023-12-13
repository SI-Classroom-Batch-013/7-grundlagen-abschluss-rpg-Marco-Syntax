import java.awt.Color

open class Action {
    open val zaubersprueche: MutableMap<String, Int> = mutableMapOf(
        "expecto patronum" to  50,
        "stupor" to  100,
        "expelliarmus" to  150,
        "avada kedavra" to  200
    )
//Hier wird der Schaden von der map genommen man gibt den key ein und bekommt den Value wert als zauberSpruch schaden und man hat 3 versuche
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



fun titelUeberschrift(){
    println(
        "${cyan}                                        _ __\n" +
                "        ___                             | '  \\\n" +
                "   ___  \\ /  ___         ,'\\_           | .-. \\        /|\n" +
                "   \\ /  | |,'__ \\  ,'\\_  |   \\          | | | |      ,' |_   /|\n" +
                " _ | |  | |\\/  \\ \\ |   \\ | |\\_|    _    | |_| |   _ '-. .-',' |_   _\n" +
                "// | |  | |____| | | |\\_|| |__    //    |     | ,'_`. | | '-. .-',' `. ,'\\_\n" +
                "\\\\_| |_,' .-, _  | | |   | |\\ \\  //    .| |\\_/ | / \\ || |   | | / |\\  \\|   \\\n" +
                " `-. .-'| |/ / | | | |   | | \\ \\//     |  |    | | | || |   | | | |_\\ || |\\_|\n" +
                "   | |  | || \\_| | | |   /_\\  \\ /      | |`    | | | || |   | | | .---'| |\n" +
                "   | |  | |\\___,_\\ /_\\ _      //       | |     | \\_/ || |   | | | |  /\\| |\n" +
                "   /_\\  | |           //_____//       .||`      `._,' | |   | | \\ `-' /| |\n" +
                "        /_\\           `------'        \\ |          `.\\  | |  `._,' /_\\\n" +
                "                                       \\|     DER MAGISCHE KAMPF           `.\\$reset"
    )
    println()
    println("      ----Der Kampf Beginnt----")
}

//Gobale variabel
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val bold = "\u001B[1m"
val underline = "\u001B[4m"
val backgroundYellow = "\u001B[43m"
val reset = "\u001B[0m"
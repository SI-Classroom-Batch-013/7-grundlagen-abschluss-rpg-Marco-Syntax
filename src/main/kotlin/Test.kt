fun main() {
    // Zauberer und Gegner erstellt
    val harryPotter: HarryPotter = HarryPotter("Harry Potter", 400, Action())
    val ronWesley: RonWesley = RonWesley("Ron Wesley", 400, Action())
    val albusDumbledore: AlbusDumbledore = AlbusDumbledore("Albus Dumbledore", 400, Action())

    val lordVoldemort: LordVoldemort = LordVoldemort("Lord Voldemort", 600)
    val nagini: Nagini = Nagini("Nagini", 300)

    var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, albusDumbledore)
    var gegner: MutableList<DunklerZauberer> = mutableListOf(lordVoldemort, nagini)

    //Bedingung für Spiel Ende
    var gameOver: Boolean = false
    // Rundenzähler
    var round: Int = 1
    //Bedingung für Bonus Attacke
    var naginiBonusAttacke = false

    // Hauptschleife für das Spiel
    while (!gameOver) {
        println("------Runde:$round------")
        println("------Dein Team---------")
        helden.forEach { println("Der Zauber ${it.name} hat Lebenspunkte: ${it.hp}") }
        println("-------Gegner Team-------")
        gegner.forEach { println("Dein Gegner ist ${it.name} und hat Lebenspunkte: ${it.hp}") }
        println("-------------------------")

        // Jeder Zauberer in der helden-Liste greift an
        for (zauber in helden) {
            println("${zauber.name} startet seinen Angriff")
            // Überprüfen, ob der Zauberer noch Lebenspunkte hat
            if (zauber.hp > 0) {
                // Überprüfen, ob Lord Voldemort als auch Nagini 0 Lebenspunkte haben wenn ja ein breakpoint gesetzt um aus der schleife raus zu kommen
                if (lordVoldemort.hp <= 0 && nagini.hp <= 0) {
                    println("Lord Voldemort und Nagini haben beide 0 Lebenspunkte. Keine weiteren Angriffe möglich.")
                    gameOver = true
                    break
                }
                // Wenn Lord Voldemort besiegt wurde, dann Nagini angreifen
                if (lordVoldemort.hp == 0 && nagini.hp > 0) {
                    println("${nagini.name} wird jetzt angegriffen")
                    zauber.angriff(nagini)
                } else {
                    zauber.angriff(lordVoldemort)
                }
            } else {
                println("${zauber.name} hat 0 Lebenspunkte und kann nicht angreifen.")
            }
        }

        // Überprüfen, ob Lord Voldemort noch Lebenspunkte hat und Angriff ausführen kann Random Angriff ausführen
        if (lordVoldemort.hp > 0) {
            println("${lordVoldemort.name} startet seinen Angriff")
            lordVoldemort.randomAngriff(helden.random())
        }


        // Wenn Lord Voldemort niedrige HP hat, ruft er Nagini zur Hilfe und führt FlächenZauber aus (Bonusattacke)
        if (lordVoldemort.hp <= 100 && nagini.hp > 0) {
            println("${lordVoldemort.name} ruft Nagini.")
            println("Nagini macht eine Attacke, und kämpft für Ihn weiter und führt eine Bonusattacke aus.")
            // Nagini führt ein Flächenzauber aus und fügt allen Zauberern Schaden zu
            nagini.flächenZauber(harryPotter, ronWesley, albusDumbledore)
            naginiBonusAttacke = true
        } else if (lordVoldemort.hp <= 300) {
            // Hier wird Nagini angreifen, wenn Lord Voldemort noch lebt und unter 300 hp ist
            println("${lordVoldemort.name} beschwört Nagini. Sie führt eine zufällige Attacke aus.")
            nagini.randomAngriff(helden.random())
        }

// Wenn Nagini noch lebt und Lord Voldemort nicht tot ist, kann er Nagini beschwören
        if (nagini.hp > 0 && lordVoldemort.hp > 0) {
            // Der Beuteltrank wird benutzt und ein zufälliger Zauberer ausgesucht, wenn Nagini den Flächenzauber angewendet hat
            println("Es wird ein zufälliger Zauberer ausgewählt der eine Heilung bekommt ")
            helden.random().beutelTrank()
        }

// Wenn Nagini ihre Bonusattacke gemacht hat und Harry Potter noch Lebenspunkte über 0 hat, darf er seine Spezialattacke Fliegen benutzen
        if (naginiBonusAttacke && harryPotter.hp > 0) {
            println("${harryPotter.name} darf jetzt seine Spezialattacke Fliegen benutzen")
            harryPotter.fliegen(nagini)
        }

        // Hier wird das Spielende geprüft
        if ((harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) || (lordVoldemort.hp <= 0 && nagini.hp <= 0)) {
            gameOver = true
        } else if (lordVoldemort.isDead && nagini.isDead) {
            gameOver = true
        }

        round++
    }

    // Spielende ausgeben
    println("Game Over")
}

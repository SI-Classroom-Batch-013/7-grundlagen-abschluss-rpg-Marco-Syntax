fun main() {
    val harryPotter: HarryPotter = HarryPotter("Harry Potter", 400, Action())
    val ronWesley: RonWesley = RonWesley("Ron Wesley", 400, Action())
    val albusDumbledore: AlbusDumbledore = AlbusDumbledore("Albus Dumbledore", 400, Action())

    val lordVoldemort: LordVoldemort = LordVoldemort("Lord Voldemort", 600)
    val nagini: Nagini = Nagini("Nagini", 300)
    var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, albusDumbledore)
    var gegener: MutableList<DunklerZauberer> = mutableListOf(lordVoldemort, nagini)

    //Bedingung für Spiel Ende
    var gameOver: Boolean = false
    // Rundenzähler
    var round: Int = 1
    //Bedingung für Bonus Attacke
    var naginiBonusAttacke = false
    while (!gameOver) {
        println("------Runde:$round------")
        helden.forEach { println("Dein Team besteht aus ${it.name} Lebenspunkte: ${it.hp}") }
        println("-------------------------")
        gegener.forEach { println("Deine Gegner sind ${it.name} Lebenspunkte:${it.hp}") }
        println("-------------------------")

        for (spieler in helden) {
            println("${spieler.name} startet seinen Angriff")

            // Überprüft, ob sowohl Lord Voldemort als auch Nagini 0 Lebenspunkte haben
            if (lordVoldemort.hp <= 0 && nagini.hp <= 0) {
                println("Lord Voldemort und Nagini haben beide 0 Lebenspunkte. Keine weiteren Angriffe möglich.")
                gameOver = true
                break
            }
            // Überprüfen, ob Lord Voldemort noch Lebenspunkte hat, wenn darf er angreifen
            if (lordVoldemort.hp > 0) {
                println("${lordVoldemort.name} startet seinen Angriff")
                lordVoldemort.randomAngriff(helden.random())
            }

            // Wenn Lord Voldemort besiegt wurde, dann Nagini angreifen
            if (lordVoldemort.hp == 0 && nagini.hp > 0) {
                println("${nagini.name} wird jetzt angegriffen")
                spieler.angriff(nagini)
            } else {
                spieler.angriff(lordVoldemort)
            }
        }
        // Wenn Lord Voldemort niedrige HP hat kleinergleich 200 Lebenspunkte , ruft Nagini zur Hilfe und führt FlächenZauber aus (Bonusattacke)
        if (lordVoldemort.hp <= 200 && nagini.hp > 0) {
            println("${lordVoldemort.name} hat nur noch ${lordVoldemort.hp} Lebenspunkte. Er ruft Nagini zur Hilfe.")
            println("Nagini macht eine Attacke, um Lord Voldemort zu unterstützen.")
            //Nagini führt ein Flaechenzauber aus fügt allen Zauber Schaden zu
            nagini.flächenZauber(harryPotter, ronWesley, albusDumbledore)
            naginiBonusAttacke = true
        }
        //Harry Potter kann nur seine Spezialattacke benutzen, wenn Nagini den Flächenzauber angewendet hat
        if (naginiBonusAttacke) {
            println("Nagini hat Bonus Attacke ausgeführt")
            println("${harryPotter.name} darf jetzt seine Spezialattacke ausführen ")
            harryPotter.fliegen(nagini)


        }
        //Hier wird das Spielende geprüft
        if ((harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) || (lordVoldemort.hp <= 0 && nagini.hp <= 0)) {
            gameOver = true
        } else if (lordVoldemort.isDead && nagini.isDead) {
            gameOver = true
        }
        round++
    }
    println("Game Over")
}


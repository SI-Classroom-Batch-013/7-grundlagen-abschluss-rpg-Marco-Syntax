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
            // Überprüfen, ob der Zauberer noch Lebenspunkte hat um anzugreifen
            if (zauber.hp > 0) {
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

//Überprüfen, ob Lord Voldemort noch Lebenspunkte hat und Angriff ausführen kann Random Angriff ausführen
        if (lordVoldemort.hp > 0) {
            println("${lordVoldemort.name} startet seinen Angriff")
            lordVoldemort.randomAngriff(helden.random())
        }

//Wenn Lord Voldemort gestorben ist, ruft er Nagini zur Hilfe und führt FlächenZauber aus (Bonusattacke) die sie einmal ausführt
        if (lordVoldemort.hp <= 0 && nagini.hp > 0 && !naginiBonusAttacke) {
            lordVoldemort.isDead = true
            println("${lordVoldemort.name} ist gestorben und hat Nagini heraufbeschworen.")
            println("Nagini macht eine Attacke, und kämpft für Ihn weiter und führt eine Bonusattacke aus.")
//Nagini führt ein Flächenzauber aus und fügt allen Zauberern Schaden zu
            nagini.flächenZauber(harryPotter, ronWesley, albusDumbledore)
            naginiBonusAttacke = true
        } else if (lordVoldemort.hp <= 300) {
//Hier wird Nagini angreifen, wenn Lord Voldemort noch lebt und unter 300 hp ist
            println("${lordVoldemort.name} beschwört Nagini. Sie führt eine zufällige Attacke aus.")
            nagini.randomAngriff(helden.random())
        }

//Wenn die hp unter 200 ist, wird einem zufälligen Zauber ein Heiltrank gegeben der darf nur einmal pro runde benutzt werden
        if (harryPotter.hp <= 200 || ronWesley.hp <= 200 || albusDumbledore.hp <= 200) {
            // Der Beuteltrank wird benutzt und ein zufälliger Zauberer ausgesucht
            println("Es wird ein zufälliger Zauberer ausgewählt der eine Heilung bekommt ")
            helden.random().beutelTrank()
            harryPotter.beutelTrank = true
            ronWesley.beutelTrank = true
            albusDumbledore.beutelTrank = true
        }

//Wenn Nagini ihre Bonusattacke gemacht hat und Harry Potter noch Lebenspunkte über 0 hat, darf er seine Spezialattacke Fliegen benutzen
        if (naginiBonusAttacke && nagini.hp > 0 && harryPotter.hp > 0) {
            println("${harryPotter.name} darf jetzt seine Spezialattacke Fliegen benutzen")
            harryPotter.fliegen(nagini)
            //Wenn Harry potter tot ist darf Ron dafür seine Spezialattcke ausführen
        } else if (naginiBonusAttacke && nagini.hp > 0 && harryPotter.hp < 0) {
            println("Ron Wesley darf seine Spezialattacke anwenden und ruf seine Ratte Krätze")
            ronWesley.ratteKrätze(nagini)
            //Wenn Ron Wesley tot ist darf Albus Dumbeldore sein Phönix rufen
        } else if (naginiBonusAttacke && nagini.hp > 0 && ronWesley.hp < 0) {
            println("Ron Wesley darf seine Spezialattacke anwenden und ruf seine Ratte Krätze")
            albusDumbledore.fawkesAttacke(nagini)
        }
// Hier wird das Spielende geprüft
        if (lordVoldemort.hp <= 0 && nagini.hp <= 0) {
            gameOver = true
            println("Das Team der Zauberer hat gewonnen!")

        } else if (harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) {
            gameOver = true
            println("Das Team der Dunkeler Zauber hat gewonnen!")
        } else if (lordVoldemort.isDead || nagini.isDead) {
            println("Das Team der Zauberer hat gewonnen!")
        }
        round++
    }
    // Spielende ausgeben
    println("Game Over")
}

fun main() {
    // Zauberer und Gegner erstellt
    val harryPotter: HarryPotter = HarryPotter("Harry Potter", 300, Action())
    val ronWesley: RonWesley = RonWesley("Ron Wesley", 300, Action())
    val albusDumbledore: AlbusDumbledore = AlbusDumbledore("Albus Dumbledore", 300, Action())

    val lordVoldemort: LordVoldemort = LordVoldemort("Lord Voldemort", 600)
    val nagini: Nagini = Nagini("Nagini", 300)

    var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, albusDumbledore)
    var gegner: MutableList<DunklerZauberer> = mutableListOf(lordVoldemort, nagini)
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

    //Bedingung für Spiel Ende
    var gameOver: Boolean = false
    // Rundenzähler
    var round: Int = 1
    //Bedingung für Bonus Attacke
    var naginiBonusAttacke = false
    var naginiSchlangenBiss = false


    println(
        "$magenta                                        _ __\n" +
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
    // Hauptschleife für das Spiel
    while (!gameOver) {
        println("         ----Runde:$round----")
        println()
        println("$magenta-----Dein Team-----$reset")
        helden.forEach { println("$magenta Der Zauber ${it.name} hat Lebenspunkte: ${it.hp}$reset") }
        println()
        println("$red------Gegner Team-----$reset")
        gegner.forEach { println("$red Dein Gegner ist ${it.name} und hat Lebenspunkte: ${it.hp}$reset") }

// Jeder Zauberer in der helden-Liste greift an
        for (zauber in helden) {
            println("$blue${zauber.name} startet seinen Angriff")
            // Überprüfen, ob der Zauberer noch Lebenspunkte hat um anzugreifen
            if (zauber.hp > 0) {
// Wenn Lord Voldemort besiegt wurde, dann Nagini angreifen
                if (lordVoldemort.hp == 0 && nagini.hp > 0 && !nagini.isDead) {
                    println("${nagini.name} wird jetzt angegriffen")
                    zauber.angriff(nagini)
                    if (nagini.hp == 0) {
                        nagini.isDead = true
                        gameOver = true
                    }
                } else {
                    zauber.angriff(lordVoldemort)
                }
            } else {
                println("${zauber.name} hat 0 Lebenspunkte und kann nicht angreifen.")
            }
            //hier wird das spielende geprüft
            if (lordVoldemort.hp <= 0 && nagini.hp <= 0) {
                println("Die Zauberer haben gewonnen ")
                gameOver = true
                break
            } else if (harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) {
                println("Das Team der Dunkeln Magie hat gewonnen!")
                gameOver = true
                break
            } else if (lordVoldemort.isDead && nagini.isDead) {
                println("Die Zauberer haben gewonnen!")
                gameOver = true
                break
            }

        }


//Überprüfen, ob Lord Voldemort noch Lebenspunkte hat und Angriff ausführen kann Random Angriff ausführen
        if (lordVoldemort.hp > 0) {
            println("${lordVoldemort.name} startet seinen Angriff")
            lordVoldemort.randomAngriff(helden.random())
// Wenn Lord Voldemort keine hp mehr hat, dann greift nagini an
        } else if (lordVoldemort.hp == 0) {
            nagini.randomAngriff(helden.random())
        }
//Wenn Lord Voldemort gestorben ist, ruft er Nagini zur Hilfe und Nagini führt FlächenZauber aus (Bonusattacke) aus die sie einmal ausführt
        if (lordVoldemort.hp <= 0 && !naginiBonusAttacke) {
            lordVoldemort.isDead = true
            println("${lordVoldemort.name} ist gestorben und hat Nagini herbeigerufen.")
            println("Nagini taucht auf  führt eine Bonusattacke (Flächenzauber) aus die alle Zauber verletzt.")
            println()
//Nagini führt ein Flächenzauber aus und fügt allen Zauberern Schaden zu
            nagini.flächenZauber(harryPotter, ronWesley, albusDumbledore)
            println()
            naginiBonusAttacke = true
//Zusatz Attacke für voldemort, wenn hp 300 sind
        } else if (lordVoldemort.hp == 300) {
//Hier wird Nagini angreifen, wenn Lord Voldemort noch lebt und 300 hp ist als zusatzattacke
            println()
            println("${lordVoldemort.name} wurde schwer Verletzt und ruft Nagini zur Hilfe. Sie beißt zu!")
            nagini.schlagenBiss(helden.random())
            naginiSchlangenBiss = true
            println()
        }
        //Wenn der Schlagenbiss true ist, dann wird ein Magisches elixier aufgerufen ein zufälliger Zauberer bekommt einmalig das elixier und die hp wird um 10 % erhöht
        if (naginiSchlangenBiss) {
            helden.random().vitamine()
            harryPotter.vitaminZugriff = false
            ronWesley.vitaminZugriff = false
            albusDumbledore.vitaminZugriff = false

        }
// Wenn die hp unter 200 ist, wird einem zufälligen Zauber ein Heiltrank gegeben.
// Der Heiltrank darf nur einmal pro Runde benutzt werden, und wenn ein Zauberer tot ist, bekommt er keinen mehr. wird mit einer range überprüft
        if ((harryPotter.hp in 1..200) || (ronWesley.hp in 1..200) || (albusDumbledore.hp in 1..200)) {
            // Der Beuteltrank wird benutzt und ein zufälliger lebender Zauberer wird ausgewählt mit der filter funktion
            val zaubererMitHeiltrank = helden.filter { it.hp > 0 }.random()
            println("Es wird ein zufälliger lebender Zauberer ausgewählt, der eine Heilung bekommt: ${zaubererMitHeiltrank.name}")
            zaubererMitHeiltrank.beutelTrank()
            println()
        }
//Wenn Nagini ihre Bonusattacke gemacht (true) hat und Ron Wesley seine hp kleiner 200 und Albus Dumbeldore seine hp kleiner 200 sind, darf Harry Potter seine Spezialattacke ausführen
        if (naginiBonusAttacke && nagini.hp > 0 && ronWesley.hp < 300 && albusDumbledore.hp < 300) {
            //Überprüft ob Bonusattacke nicht true ist
            if (!harryPotter.bonusAttacke) {
                println("${harryPotter.name} darf jetzt seine Spezialattacke Fliegen benutzen")
                println(
                    "            _            _.,----,\n" +
                            " __  _.-._ / '-.        -  ,._  \\) \n" +
                            "|  `-)_   '-.   \\       / < _ )/\" }\n" +
                            "/__    '-.   \\   '-, ___(c-(6)=(6)\n" +
                            " , `'.    `._ '.  _,'   >\\    \"  )\n" +
                            " :;;,,'-._   '---' (  ( \"/`. -='/\n" +
                            ";:;;:;;,  '..__    ,`-.`)'- '--'\n" +
                            ";';:;;;;;'-._ /'._|   Y/   _/' \\\n" +
                            "      '''\"._ F    |  _/ _.'._   `\\\n" +
                            "             L    \\   \\/     '._  \\\n" +
                            "      .-,-,_ |     `.  `'---,  \\_ _|\n" +
                            "      //    'L    /  \\,   (\"--',=`)7\n" +
                            "     | `._       : _,  \\  /'`-._L,_'-._\n" +
                            "     '--' '-.\\__/ _L   .`'         './/\n" +
                            "                 [ (  /\n" +
                            "                  ) `{\n" +
                            "       snd        \\__)"
                )
                harryPotter.fliegen(nagini)
                harryPotter.bonusAttacke = true
                println()
            }

            //Wenn Harry Potter seine hp kleiner 200 und Albus Dumbledore hp kleiner 200 sind, darf Ron Wesley seine Spezialattacke ausführen
        } else if (naginiBonusAttacke && nagini.hp >= 0 && harryPotter.hp < 300 && albusDumbledore.hp < 300) {
            if (!ronWesley.bonusAttacke) {
                println()
                println("Ron Wesley darf seine Spezialattacke anwenden und ruf seine Ratte Krätze")
                println(
                    "      /m'\n" +
                            "      (oo\\\n" +
                            "      / ._)\n" +
                            "     J _=\\=\n" +
                            "     |   /\n" +
                            "3._.' |_+_"
                )
                ronWesley.ratteKrätze(nagini)
                ronWesley.bonusAttacke = true
            }
            //Wenn Harry Potter seine hp kleiner 200 und Ron Wesley hp kleiner 200 sind, darf Albus Dumbledore seine Spezialattacke ausführen
        } else if (naginiBonusAttacke && nagini.hp >= 0 && harryPotter.hp <= 300 && ronWesley.hp <= 300) {
            if (!albusDumbledore.bonusAttacke) {
                println()
                println("Albus Dumbledore darf seine Spezialattacke anwenden und ruf seinen Phönix Fakes")
                println(
                    "                              ___,--------,____\n" +
                            "                      __--~~~~                 ~~---,_\n" +
                            "                   ,-'                  __,--,_       `\\,___,-,__\n" +
                            "                ,-'                 __/'/-~~~\\  `  ` . '    , |  `~~\\\n" +
                            "             _/`      _/~~      '~~   \\,_\\_ O /        '  '~_/'      `\\\n" +
                            "           /'        '                   =-'~~  _  /  ~   /'          `\\\n" +
                            "        _/'  /~                            ,--,____,-----|,_,-,_       `\\\n" +
                            "    _,/'    '              ,-'      _      `~'------'~~~~~--    `~~~~\\  |\n" +
                            " ,-'             /~       '    ,-~~~         _,       ,-=~~~~~~~~~~~~'| |\n" +
                            "~              .'             '         ,   '      /~`                |/\n" +
                            "                                  /' ,/'       _/~'\n" +
                            "                   ,       /    /`          _/~ \n" +
                            "        /~        /      /`               /' \n" +
                            "      .'                                /' \n" +
                            "                       /'      .      /\n" +
                            "                      `       /'     | \n" +
                            "                                    '"
                )
                albusDumbledore.fawkesAttacke(nagini)
                albusDumbledore.bonusAttacke = true
            }
        }

        round++
    }
    // Spielende ausgeben

    println("ENDE")
}

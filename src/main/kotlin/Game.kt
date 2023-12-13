
fun spiel(helden: MutableList<Zauberer>, gegner:MutableList<DunklerZauberer>){
    while (!gameOver) {
        println("         ----Runde:$round----")
        println()
        println("$blue-----Dein Team-----$reset")
        helden.forEach { println("$blue Der Zauber ${it.name} hat Lebenspunkte: ${it.hp}$reset") }
        println()
        Thread.sleep(2000)
        println("$red------Gegner Team-----$reset")
        gegner.forEach { println("$red Dein Gegner ist ${it.name} und hat Lebenspunkte: ${it.hp}$reset") }
        Thread.sleep(2000)

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
                    //Angriff auf Lord Voldemort
                    zauber.angriff(lordVoldemort)
                }
            } else {
                println("${zauber.name} hat 0 Lebenspunkte und kann nicht angreifen.")
            }
            //hier wird das spielende geprüft
            if (lordVoldemort.hp <= 0 && nagini.hp <= 0) {
                println("${magenta}Die Zauberer haben gewonnen $reset")
                gameOver = true
                break
            } else if (harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) {
                println("Das Team der Dunkeln Magie hat gewonnen!")
                gameOver = true
                break
            } else if (lordVoldemort.isDead && nagini.isDead) {
                println("${magenta}Die Zauberer haben gewonnen!$reset")
                gameOver = true
                break
            }


        }
        //Hier ist der Held der Vergiftet wurden ist der auch das elixier bekommt
        var heldIstVergiftet =helden.random()

//Überprüfen, ob Lord Voldemort noch Lebenspunkte hat und Angriff ausführen kann Random Angriff ausführen
        if (lordVoldemort.hp > 0) {
            println()
            println("$red${lordVoldemort.name} startet seinen Angriff")
            lordVoldemort.randomAngriff(helden.random())
// Wenn Lord Voldemort keine hp mehr hat, dann greift nagini an
        } else if (lordVoldemort.hp == 0 && nagini.hp > 0) {
            lordVoldemort.isDead = true
            nagini.randomAngriff(helden.random())
        } else if (nagini.hp <= 0) {
            nagini.isDead = true
        }
//Wenn Lord Voldemort gestorben ist, ruft er Nagini zur Hilfe und Nagini führt FlächenZauber aus (Bonusattacke) aus die sie einmal ausführt
        if (lordVoldemort.hp <= 0 && !naginiBonusAttacke) {
            println()
            lordVoldemort.isDead = true
            Thread.sleep(2000)
            println("$red${lordVoldemort.name} ist gestorben und hat Nagini herbeigerufen.")
            println("$red Nagini taucht auf  führt eine Bonusattacke (Flächenzauber) aus die alle Zauberer verletzt.$reset")
            println()
//Nagini führt ein Flächenzauber aus und fügt allen Zauberern Schaden zu
            nagini.flächenZauber(harryPotter, ronWesley, albusDumbledore)
            Thread.sleep(2000)
            println()
            naginiBonusAttacke = true
//Zusatz Attacke für voldemort, wenn hp 300 sind
        } else if (lordVoldemort.hp == 300 && !gameOver) {
//Hier wird Nagini angreifen, wenn Lord Voldemort noch lebt und 300 hp ist als zusatzattacke
            println()
            Thread.sleep(2000)
            println("${lordVoldemort.name} wurde schwer Verletzt und ruft Nagini zur Hilfe. Sie beißt zu!")

                nagini.schlagenBiss(heldIstVergiftet)

            println("$green           /^\\/^\\\n" +
                    "         _|__|  O|\n" +
                    "\\/     /~     \\_/ \\\n" +
                    " \\____|__________/  \\\n" +
                    "        \\_______      \\\n" +
                    "                `\\     \\                 \\\n" +
                    "                  |     |                  \\\n" +
                    "                 /      /                    \\\n" +
                    "                /     /                       \\\\\n" +
                    "              /      /                         \\ \\\n" +
                    "             /     /                            \\  \\\n" +
                    "           /     /             _----_            \\   \\\n" +
                    "          /     /           _-~      ~-_         |   |\n" +
                    "         (      (        _-~    _--_    ~-_     _/   |\n" +
                    "          \\      ~-____-~    _-~    ~-_    ~-_-~    /\n" +
                    "            ~-_           _-~          ~-_       _-~\n" +
                    "               ~--______-~                ~-___-~\n$reset")
            naginiSchlangenBiss = true
            println()
            Thread.sleep(1000)
            heldIstVergiftet.isVergiftet =true
            heldIstVergiftet.gift()

        }
        //Wenn der Schlagenbiss true ist, dann wird ein Magisches elixier aufgerufen ein zufälliger Zauberer bekommt einmalig das elixier und die hp wird um 10 % erhöht
        if (naginiSchlangenBiss && !gameOver) {
            heldIstVergiftet.elixier()
            //Lambdafunktion verwendet, um den Zugriff auf false zu setzen, bei allen Zauberern
            helden.map { it.elixierZugriff = false }
        }

// Wenn die hp unter oder gleich 200 ist, wird einem zufälligen Zauber ein Heiltrank gegeben.
// Der Heiltrank darf nur einmal pro Runde benutzt werden, und wenn ein Zauberer tot ist, bekommt er keinen mehr. wird mit einer range überprüft
        if (((harryPotter.hp in 1..200) || (ronWesley.hp in 1..200) || (albusDumbledore.hp in 1..200)) && !gameOver) {
            // Der Beuteltrank wird benutzt und ein zufälliger lebender Zauberer wird ausgewählt mit der Lambdafunktion filter wird überprüft, ob die hp zwischen 1 und 200 liegen
            val zaubererMitHeiltrank: Zauberer = helden.filter { it.hp > 0 }.random()
            Thread.sleep(2000)
            println("${yellow}Es wird ein lebender Zauberer ausgewählt, der eine Heilung bekommt: ${zaubererMitHeiltrank.name}$reset")
            zaubererMitHeiltrank.beutelTrank()
            println()
        }

//Wenn Nagini ihre Bonusattacke gemacht (true) hat und Ron Wesley seine hp kleiner 300 und Albus Dumbeldore seine hp kleiner 200 sind, darf Harry Potter seine Spezialattacke ausführen
        if (naginiBonusAttacke && nagini.hp > 0 && harryPotter.hp > 200) {
            //Überprüft ob Bonusattacke nicht true ist
            if (!harryPotter.bonusAttacke) {
                Thread.sleep(2000)
                println("$yellow${harryPotter.name} darf jetzt seine Spezialattacke Fliegen benutzen")
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
                            "                  \\__)"
                )
                harryPotter.fliegen(nagini)
                harryPotter.bonusAttacke = true
                println()
                Thread.sleep(2000)
            }
            //Wenn Harry Potter seine hp kleiner 300 und Albus Dumbledore hp kleiner 300 sind, darf Ron Wesley seine Spezialattacke ausführen
        } else if (naginiBonusAttacke && nagini.hp > 0 && ronWesley.hp > 200) {
            if (!ronWesley.bonusAttacke) {
                println()
                Thread.sleep(2000)
                println("$yellow Ron Wesley darf seine Spezialattacke anwenden und ruf seine Ratte Krätze")
                println(
                    "      ,::////;::-.\n" +
                            "      /:'///// ``::>/|/\n" +
                            "    .',  ||||    `/( e\\\n" +
                            "-==~-'`-Xm````-mm-' `-_\\"
                )
                ronWesley.ratteKrätze(nagini)
                Thread.sleep(2000)
                ronWesley.bonusAttacke = true
            }
            //Wenn Harry Potter seine hp kleiner 200 und Ron Wesley hp kleiner 200 sind, darf Albus Dumbledore seine Spezialattacke ausführen
        } else if (naginiBonusAttacke && nagini.hp > 0 && albusDumbledore.hp > 200) {
            if (!albusDumbledore.bonusAttacke) {
                println()
                Thread.sleep(2000)
                println("$yellow Albus Dumbledore darf seine Spezialattacke anwenden und ruf seinen Phönix Fakes")
                println(
                    "                   /T /I          \n" +
                            "                              / |/ | .-~/    \n" +
                            "                          T\\ Y  I  |/  /  _  \n" +
                            "         /T               | \\I  |  I  Y.-~/  \n" +
                            "        I l   /I       T\\ |  |  l  |  T  /   \n" +
                            " __  | \\l   \\l  \\I l __l  l   \\   `  _. |    \n" +
                            " \\ ~-l  `\\   `\\  \\  \\\\ ~\\  \\   `. .-~   |    \n" +
                            "  \\   ~-. \"-.  `  \\  ^._ ^. \"-.  /  \\   |    \n" +
                            ".--~-._  ~-  `  _  ~-_.-\"-.\" ._ /._ .\" ./    \n" +
                            " >--.  ~-.   ._  ~>-\"    \"\\\\   7   7   ]     \n" +
                            "^.___~\"--._    ~-{  .-~ .  `\\ Y . /    |     \n" +
                            " <__ ~\"-.  ~       /_/   \\   \\I  Y   : |\n" +
                            "   ^-.__           ~(_/   \\   >._:   | l______     \n" +
                            "       ^--.,___.-~\"  /_/   !  `-.~\"--l_ /     ~\"-.  \n" +
                            "              (_/ .  ~(   /'     \"~\"--,Y   -=b-. _) \n" +
                            "               (_/ .  \\  :           / l      c\"~o \\\n" +
                            "                \\ /    `.    .     .^   \\_.-~\"~--.  ) \n" +
                            "                 (_/ .   `  /     /       !       )/  \n" +
                            "                  / / _.   '.   .':      /        ' \n" +
                            "                  ~(_/ .   /    _  `  .-<_      -Row\n" +
                            "                    /_/ . ' .-~\" `.  / \\  \\          ,z=.\n" +
                            "                    ~( /   '  :   | K   \"-.~-.______//\n" +
                            "                      \"-,.    l   I/ \\_    __{--->._(==.\n" +
                            "                       //(     \\  <    ~\"~\"     //\n" +
                            "                      /' /\\     \\  \\     ,v=.  ((\n" +
                            "                    .^. / /\\     \"  }__ //===-  `\n" +
                            "                   / / ' '  \"-.,__ {---(==-\n" +
                            "                 .^ '       :  T  ~\"   ll\n" +
                            "                / .  .  . : | :!        \\\\ \n" +
                            "               (_/  /   | | j-\"          ~^\n" +
                            "                 ~-<_(_.^-~\"               "
                )
                albusDumbledore.fawkesAttacke(nagini)
                Thread.sleep(2000)
                albusDumbledore.bonusAttacke = true
            }
        }


        round++

    }
    // Spielende ausgeben
    println("Das Spiel ist vorbei!")
}

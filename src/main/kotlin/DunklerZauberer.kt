open class DunklerZauberer(var name: String, var hp: Int, var isDead: Boolean = false) {
    //Ist eine Methode die eine Random Attacke ausführt
    fun randomAngriff(auf: Zauberer) {
        val angriffListe = listOf(
            { feuerSturm(auf) },
            { fluchDesTodes(auf) },
            { dementorenAttacke(auf) },
        )
        val randomAttacke = angriffListe.random()
        randomAttacke()
    }

    //Eine Attacke die Schaden verursacht
    fun feuerSturm(ziel: Zauberer) {
        val schadenFeuersturm = 100
        println("$name hat Attacke Feuersturm gegen ${ziel.name} angewendet. Schaden: $schadenFeuersturm punkte")
        ziel.hp -= schadenFeuersturm
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")

    }

    //Eine Attacke die schaden verursacht
    fun fluchDesTodes(ziel: Zauberer) {
        val fluchDesTodes: Int = 150
        println("$name hat Attacke Fluch des Todes gegen ${ziel.name} angeendet. Schaden: $fluchDesTodes punkte")
        ziel.hp -= fluchDesTodes
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }

    //Ist eine Methode die kann erst verwendet werden wenn die Lenbenspunkte unter 100 sind
    fun unterbossRufen() {
        if (hp <= 100) {
            println("Nagini kämpft nun an deiner Seite")

        } else {
            println("$name kann Nagini noch nicht rufen, weil die lebenspunkte noch zu hoch sind ")
        }

    }

    //Eine Attacke die schaden verursacht
    fun dementorenAttacke(ziel: Zauberer) {
        val dementorAttacke: Int = 200
        println("$name hat Attacke Dementorenattacke gegen ${ziel.name} angewendet. Schaden: $dementorAttacke punkte")
        ziel.hp -= dementorAttacke
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }

    //Die Attacke greift alle Zauber an und verursacht schaden
    fun flächenZauber(ziel1: Zauberer, ziel2: Zauberer, ziel3: Zauberer) {
        //Attacke fügt allen Zauber schaden zu
        val flaechenZauber: Int = 200
        println("$name hat Attacke Flächenzauber angewendet. Schaden: $flaechenZauber punkte")
        ziel1.hp -= flaechenZauber
        ziel2.hp -= flaechenZauber
        ziel3.hp -= flaechenZauber
        println("${ziel1.name} hat $flaechenZauber Schaden erhalten und hat noch ${ziel1.hp} lebenspunkte")
        println("${ziel2.name} hat $flaechenZauber Schaden erhalten und hat noch ${ziel2.hp} lebenspunkte")
        println("${ziel3.name} hat $flaechenZauber Schaden erhalten und hat noch ${ziel3.hp} lebenspunkte")
    }

    //Hilfsfunktion
    open fun dunklerschadenErhalten(dunklerschaden: Int) {
        hp -= dunklerschaden
        if (hp <= 0) {
            hp = 0
            println("$name wurde besiegt ")
        }
        println("$name hat $dunklerschaden Schaden erhalten. Aktuelle HP: $hp")
    }
}
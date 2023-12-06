open class DunklerZauberer(var name: String, var hp: Int, var isDead: Boolean = false) {

    fun randomAction(auf: Zauberer) {
        val aktionList = listOf(
            { feuerSturm(auf) },
            { fluchDesTodes(auf) },
            { unterbossRufen() },
            { dementorenAttacke(auf) },
            { flächenZauber(auf, auf, auf) }
        ).shuffled()
        val ersteAktion= aktionList.first()
        ersteAktion()
    }

    fun feuerSturm(ziel: Zauberer) {
        val schadenFeuersturm = 100
        println("Lord Voldemord hat Attacke Feuersturm angewendet schaden: $schadenFeuersturm punkte")
        ziel.hp -= schadenFeuersturm
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")

    }

    fun fluchDesTodes(ziel: Zauberer) {
        val fluchDesTodes: Int = 150
        println("Lord Voldemord hat Attacke Fluch des Todes angewendet schaden: $fluchDesTodes punkte")
        ziel.hp -= fluchDesTodes
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }

    fun unterbossRufen() {

        if (hp <= 100){
            println("Nagini kämpft mit dir an der Seite")
        }

    }

    fun dementorenAttacke(ziel: Zauberer) {
        val dementorAttacke: Int = 200
        println("Lord Voldemord hat Attacke Dementorenattacke angewendet schaden: $dementorAttacke punkte")
        ziel.hp -= dementorAttacke
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }

    fun flächenZauber(ziel1: Zauberer, ziel2: Zauberer, ziel3: Zauberer) {
        //Attacke fügt allen Zauber schaden zu
        val flaechenZauber: Int = 200
        println("Lord Voldemord hat Attacke Flächenzauber angewendet schaden: $flaechenZauber punkte")
        ziel1.hp -= flaechenZauber
        ziel2.hp -= flaechenZauber
        ziel3.hp -= flaechenZauber
        println("${ziel1.name} hat $flaechenZauber schaden erhalten und hat noch ${ziel1.hp} lebenspunkte")
        println("${ziel2.name} hat $flaechenZauber schaden erhalten und hat noch ${ziel2.hp} lebenspunkte")
        println("${ziel3.name} hat $flaechenZauber schaden erhalten und hat noch ${ziel3.hp} lebenspunkte")


    }

    fun dunklerangriff(schaden: Int) {
        hp -= schaden
        if (hp < 0) {
            hp = 0
        }
        println("$name hat $schaden Schaden erhalten. Aktuelle HP: $hp")
    }

    open fun dunklerschadenErhalten(dunklerschaden: Int) {
        hp -= dunklerschaden
        println("$name hat $dunklerschaden Schaden erhalten. Aktuelle HP: ${this.hp}")
    }


}
open class Zauberer(
    var name: String, var hp: Int, var action: Action, var schutzZauberAktiv: Boolean = false,
    var vitaminZugriff: Boolean = true, var isDead: Boolean = false) {



    open val zaubersprueche: MutableMap<String, Int> = mutableMapOf(
        "expecto patronum" to 50,
        "stupor" to 100,
        "expelliarmus" to 150,
        "avada kedavra" to 300
    )


    open fun zauberSpruchAnwenden(): Int? {
        return action.zauberSpruchAnwenden(readln())
    }


    var zahl = 1
    open fun angriff(ziel: DunklerZauberer) {
        for (i in zaubersprueche) {
            println("$zahl. $i")
            zahl++
        }
        println("${name} möchte ${ziel.name} angreifen")
        println("Bitte gib ein Zauberspruch ein:")
        // Hier kann man verschiedene Zaubersprüche auswählen über die Konsole
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            ziel.dunklerschadenErhalten(schaden)
        }else if (hp <= 0 ){
            isDead = true
            println("$name kann nicht weiter spielen")
        }
    }

    fun heilungsmethoden() {
        val heilung: Int = 100
        println(
            "$name hat eine Heilungsmethode angewendet und erhält $heilung lebenspunkte Heilung" +
                    " \nDie neuen Lebenspunkte von $name sind  ${heilung + hp}"
        )
    }

    fun schutz() {
        val reduzierterSchaden = zauberSpruchAnwenden()
        if (schutzZauberAktiv) {
            println("$name versucht sich gegen den Angriff zu schützen.")
            if (reduzierterSchaden != null) {
                hp -= reduzierterSchaden
            }
        }
        println("$name hat sich erfolgreich gegen den Angriff geschützt. Aktuelle HP: $hp")

    }
    var heiltrankAnwendungen = 3
    fun beutelTrank() {
        if (heiltrankAnwendungen >= 0) {
            // Heilt den Zauberer um die Hälfte seiner Lebenspunkte
            val heilung = hp / 2
            hp += heilung
            println("$name hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }

    fun vitamine() {
        if (vitaminZugriff) {
            val erhöhung = hp / 100 * 10
            println("$name hat Vitamine genommen. Seine Energie wird  um 10% erhöht.")
            hp += erhöhung
            vitaminZugriff = false
        } else {
            println("$name hat keinen Zugriff mehr auf die Vitamine in dieser Runde.")
        }
    }


}

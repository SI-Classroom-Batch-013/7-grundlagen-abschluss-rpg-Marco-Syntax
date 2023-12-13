open class Zauberer(
    var name: String, var hp: Int, var action: Action,
    var schutzZauberAktiv: Boolean = false,
    var elixierZugriff: Boolean = true,
    var beutelTrank: Boolean = false,
    var bonusAttacke: Boolean = false,
    var isVergiftet: Boolean = false
) {

    open val zaubersprueche: MutableMap<String, Int> = mutableMapOf(
        "expecto patronum" to 50,
        "stupor" to 100,
        "expelliarmus" to 150,
        "avada kedavra" to 200,
    )

    //Hilfsfunktion
    open fun zauberSpruchAnwenden(): Int? {
        return action.zauberSpruchAnwenden(readln())
    }

    //Gibt die Liste mit Zaubersprüchen aus mit einer for i schleife aus
    fun zauberSpruchListe() {
        var zahl = 1
        for (i in zaubersprueche) {
            println("$zahl. $i")
            zahl++
        }
    }

    // Führt ein Angriff aus
    open fun angriff(ziel: DunklerZauberer) {
        println("$blue$name hat $hp Lebenspunkte und möchte ${ziel.name} angreifen er hat ${ziel.hp} Lebenspunkte")
        println()
        zauberSpruchListe()
        println("Bitte gib ein Zauberspruch ein:$reset")
        // Hier kann man verschiedene Zaubersprüche auswählen über die Konsole
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            ziel.dunklerschadenErhalten(schaden)
        } else if (ziel.hp <= 0) {
            ziel.isDead = true
        }
    }
    //Hier wird dem Zauber "das Gift" abgezogen
    open fun gift() {
       if (isVergiftet) {
            println("$name ist vergiftet Aktuelle :$hp")
            if (hp > 0) {
                hp -= (hp * 0.1).toInt()
                println("$name hat $hp Lebenspunkte das Gift zieht ihm weiter 10% ab")
            isVergiftet=false
            }
       }
    }

    //Heilt den Zauber um die hälfte seine Lebenspunkte
    fun heilungsmethoden() {
        val heilung: Int = hp / 2
        hp + heilung
        println(
            "$name hat eine Heilungsmethode angewendet und erhält $heilung lebenspunkte Heilung" +
                    " \nDie neuen Lebenspunkte von $name sind  $hp"
        )
    }

    //Gibt dem Zauber Schutz vor der Attacke
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

    //Der Beuteltrank kann nur dreimal verwendet werden
    var heiltrankAnwendungen = 3
    fun beutelTrank() {
        if (heiltrankAnwendungen > 0) {
            // Heilt den Zauberer um die Hälfte seiner Lebenspunkte
            val heilung = 200
            hp += heilung
            println("$yellow$name hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt$reset.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }

    //Steht nur einmal zur Verfügung erhöht die Lebenspunkte um 10
    var elixierAnzahl = 1
    fun elixier() {
        if (elixierZugriff) {
            val heilung = 10
            println("${yellow}Naginis Biss war giftig es wird Heilzauber beschworen ")
            println("$name bekommt ein Zauberelixier . Seine Energie wird jetzt  um 10 hp erhöht.")
            hp += heilung
            elixierAnzahl--

        } else {
            println("$yellow$name hat keinen Zugriff auf das Zauberelixier.$reset")
        }
    }
}

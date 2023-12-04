open class Zauberer(var name: String, var hp: Int, var action: Action) {
    var schutzZauberAktiv = false
    // 4 methoden
    open fun angriff(ziel: DunklerZauberer) {
        println("${name} möchte ${ziel.name} angreifen?")
        println("Bitte gib ein Zauberspruch ein:")
        // Hier kann man verschiedene Zaubersprüche auswählen über die readline
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            ziel.schadenErhalten(schaden)
        }
    }
    open fun schadenErhalten(schaden: Int) {
        hp -= schaden
        if (hp < 0) {
            hp = 0
        }
        println("$name hat $schaden Schaden erhalten. Aktuelle HP: $hp")
    }
    open fun heilungsmethoden(){}
    open fun schutz(){
        schutzZauberAktiv=true
        println("Der Schutzzauber ist Aktik für $name")

    }

    //3 Heiltränke die nur einmal die runde verfügbar sind
    //Heilt den Zauber um die hälfte seiner Punkte
    //Gesundheit dauerhaft um 10% verstärken

}

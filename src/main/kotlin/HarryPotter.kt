open class HarryPotter(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()){

    fun fliegen(ziel: DunklerZauberer) {
        println("$name hat seinen Besen gerufen, um den Gegner zu verwirren.")
        println("Du darfst noch einen Angriff ausführen.")
        // Hier kann man  zusätzlichen Angriff ausführen
        println("Bitte gib einen Zauberspruch für den Angriff ein: ")
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            // Hier wird der zusätzliche Schaden gegen das Ziel angewendet
            ziel.schadenErhalten(schaden)
        }
    }

    var heiltrankAnwendungen = 3
    fun beutelTrank(auf: Zauberer) {
        if (heiltrankAnwendungen > 0) {
            // Frei wählbar! Einmal in jeder Runde verfügbar
            // Heilt den Zauber um die Hälfte seiner Lebenspunkte
            val heilung = auf.hp / 2
            auf.hp += heilung

            println("${auf.name} hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }
    fun vitamine(){
        var hp = hp / 100 * 10
        println("$name hat Vitamine genommen seine Energie wird dauerhaft um 10% erhöht ")
    }

}
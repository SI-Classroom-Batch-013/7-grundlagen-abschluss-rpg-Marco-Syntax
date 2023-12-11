open class HarryPotter(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()) {

    fun fliegen(ziel: DunklerZauberer) {
        println("$name hat seinen Besen gerufen, um den Gegner zu verwirren.")
        println("Er darfst noch einen Angriff ausführen.")
        // Hier kann man zusätzlichen Angriff ausführen
        println("$name Bitte gib einen Zauberspruch für den Angriff ein: ")
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            // Hier wird der zusätzliche Schaden gegen das Ziel ausgeben
            ziel.dunklerschadenErhalten(schaden)
        }
    }

}
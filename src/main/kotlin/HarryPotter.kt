open class HarryPotter(name: String, hp: Int, action: Action) :  Zauberer(name, hp, action){

    fun fliegen(ziel: DunklerZauberer) {
        println("$name hat seinen Besen gerufen, um den Gegner zu verwirren.")
        println("Du darfst noch einen Angriff ausführen.")
        // Hier kann man  zusätzlichen Angriff ausführen
        println("Bitte gib einen Zauberspruch für den Angriff ein: ")
        val schaden = action.zauberSpruchAnwenden(readln())
        if (schaden != null) {
            // Hier wird der zusätzliche Schaden gegen das Ziel angewendet
            ziel.dunklerschadenErhalten(schaden)
        }
    }

}
open class DunklerZauberer(var name: String, var hp: Int) {

    fun randomAction(auf: Zauberer) {
        listOf(feuerSturm(auf), fluchDesTodes(auf), unterbossRufen(), schutz(), heillung())
    }

    fun feuerSturm(ziel: Zauberer) {
        var schadenFeuersturm = 100
        println("Lord Voldemord hat Attacke Feuersturm angewendet schaden: $schadenFeuersturm punkte")
        ziel.hp -= schadenFeuersturm
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")

    }

    fun fluchDesTodes(ziel: Zauberer) {
        val fluchDesTodes: Int = 300
        println("Lord Voldemord hat Attacke Fluch des Todes angewendet schaden: $fluchDesTodes punkte")
        ziel.hp -= fluchDesTodes
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }

    fun unterbossRufen() {

        //Soll den unterboss rufen
    }

    fun schutz() {

        //Schutz vor Attacke
    }

    fun heillung() {
        //Heillung mit dierktem Effekt
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
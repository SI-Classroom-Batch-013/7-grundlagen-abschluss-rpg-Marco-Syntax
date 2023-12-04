open class DunklerZauberer(var name:String, var hp:Int) {

    // sechs methoden
    //Feueratem
    //Fluch
    fun randomAction() {
        listOf(feuerSturm(),fluchDesTodes(),unterbossRufen(),schutz(),heillung())
    }
    fun feuerSturm(){
        //Soll jeden Zauber Schaden zufügen
    }
    fun fluchDesTodes(){
        //Soll eine besonnders starke Attacke sein
    }
    fun unterbossRufen(){
        //Soll den unterboss rufen
    }
    fun schutz(){
        //Schutz vor Attacke
    }
    fun heillung(){

        //Heillung mit dierktem Effekt
    }
    open fun angriff(ziel: Zauberer) {
        println("${name} möchte ${ziel.name} angreifen?")
        println("Bitte gib ein Zauberspruch ein:")
        // Hier kann man verschiedene Zaubersprüche auswählen über die readline
        val schaden = feuerSturm()
        if (schaden != null) {
             ziel.schadenErhalten(ziel.hp)
        }
    }

    open fun schadenErhalten(schaden: Int) {
        hp -= schaden
        if (hp < 0) {
            hp = 0
        }
        println("$name hat $schaden Schaden erhalten. Aktuelle HP: $hp")
    }

}
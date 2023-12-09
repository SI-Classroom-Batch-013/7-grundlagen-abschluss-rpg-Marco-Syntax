class Nagini (name:String,hp:Int): DunklerZauberer (name, hp) {

    fun schlagenBiss(ziel: Zauberer) {
        val schlagenBiss = 100
        if (ziel.hp > 0) {
            println("$name hat Attacke Schlagenbiss gegen ${ziel.name} angewendet. Schaden: $schlagenBiss punkte")
            ziel.hp -= schlagenBiss
            println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
        } else if (ziel.hp == 0) {
            println("${ziel.name} wurde besiegt")
        }
    }

}
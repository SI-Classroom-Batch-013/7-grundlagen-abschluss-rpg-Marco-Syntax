class Nagini (name:String,hp:Int): DunklerZauberer (name, hp) {

    fun schlagenBiss(ziel: Zauberer) {
        val schlagenBiss = 100
        if (ziel.hp > 0) {
            Thread.sleep(2000)
            println("$red$name hat Attacke Schlagenbiss gegen ${ziel.name} angewendet. Schaden: $schlagenBiss punkte$reset")
            ziel.hp -= schlagenBiss
            println("$red${ziel.name} hat noch ${ziel.hp} lebenspunkte$reset")
        } else if (ziel.hp == 0) {
            println("${ziel.name} wurde besiegt")
        }
    }

}
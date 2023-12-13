class Nagini (name:String,hp:Int): DunklerZauberer (name, hp) {

    fun schlagenBiss(ziel: Zauberer) {
        val schlagenBiss = 100
        if (ziel.hp > 0) {
            Thread.sleep(2000)
            println("$green$name hat Attacke Schlagenbiss gegen ${ziel.name} angewendet. Schaden: $schlagenBiss punkte$reset")
            ziel.hp -= schlagenBiss
            println("$green${ziel.name} hat noch ${ziel.hp} lebenspunkte und wurde vergiftet$reset")
        } else if (ziel.hp == 0) {
            println("${ziel.name} wurde besiegt")
        }
    }

}
//var ist vergiftet muss jeder held haben
//for schleife sind die vergifte dann ziehe immer 10% ab
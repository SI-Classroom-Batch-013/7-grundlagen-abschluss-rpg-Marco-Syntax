open class RonWesley(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()) {

    //ruf seine Ratte Krätze und kann extra schaden verursachen

    fun ratteKrätze(ziel: DunklerZauberer) {
        println("$name hat sein Wandlungzauber (100 Punkte schaden) angewendet seine Attacke wird um 50 schadenspunkte verstärkt  durch seine Ratte Krätze")
        val wandlungZauber: Int = 50
        ziel.hp -= wandlungZauber + 100
        println("Die Attacke hat ${wandlungZauber + 100} schaden verursacht")
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }


}
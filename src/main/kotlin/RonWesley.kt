open class RonWesley(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()){

    //ruf seine Ratte Krätze und kann extra schaden verursachen

    fun ratteKrätze(ziel:DunklerZauberer){
        println("$name hat sein Wandlungzauber angewendet seine Attacke wird um 50 schadenspunkte verstärkt")
        val wandlungZauber: Int = 50
        ziel.hp -= wandlungZauber + 100
        println("Die Attacke hat $wandlungZauber schaden verursacht")
        println("${ziel.name} hat noch ${ziel.hp} lebenspunkte")
    }




}
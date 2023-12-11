open class AlbusDumbledore(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()) {

    //Fawkes attacke anwenden
    fun fawkesAttacke(ziel: DunklerZauberer) {
        println("$name hat sein Phönix FAWKES gerufen und führt seine Attacke Feuerball aus")
        val feuerball: Int = 100
        ziel.hp -= feuerball
        println("Die Attacke hat $feuerball schaden verursacht bei ${ziel.name}")
    }

}

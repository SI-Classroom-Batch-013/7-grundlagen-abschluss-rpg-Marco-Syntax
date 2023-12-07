fun main() {
    val harryPotter: HarryPotter = HarryPotter("Harry Potter", 400, Action())
    val ronWesley: RonWesley = RonWesley("Ron Wesley", 400, Action())
    val albusDumbledore: AlbusDumbledore = AlbusDumbledore("Albus Dumbledore", 400, Action())

    val lordVoldemort: LordVoldemort = LordVoldemort("Lord Voldemort", 600)
    val nagini: Nagini = Nagini("Nagini", 300)

    var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, albusDumbledore)
    var gegener: MutableList<DunklerZauberer> = mutableListOf(lordVoldemort, nagini)


    var gameOver: Boolean = false
    // Rundenzähler
    var round: Int = 1
    while (!gameOver) {
        println("------Runde:$round------")
        helden.forEach { println("Dein Team besteht aus ${it.name} Lebenspunkte:${it.hp}")}
        println("-------------------------")
        gegener.forEach { println("Deine Gegner sind ${it.name} Lebenspunkte:${it.hp}") }
        println("-------------------------")
        for (spieler in helden){
            println("${spieler.name} startet seinen Angriff")
            spieler.angriff(gegener.random())
        }
        if (lordVoldemort.hp > 0) {
            lordVoldemort.randomAngriff(helden.random())
        }
        if (lordVoldemort.hp <= 100) {
            println("Nagini macht eine Attacke um Lord Voldemort zu unterstützen")
            nagini.dementorenAttacke(helden.random())
        }
        if ((harryPotter.hp <= 0 && ronWesley.hp <= 0 && albusDumbledore.hp <= 0) || (lordVoldemort.hp <= 0 && nagini.hp <= 0)) gameOver =
            true

        round++
    }
    println("Game Over")
}


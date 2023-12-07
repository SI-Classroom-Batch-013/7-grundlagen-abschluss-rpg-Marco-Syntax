fun main() {
    val harryPotter: HarryPotter = HarryPotter("Harry Potter", 500, Action())
    val ronWesley: RonWesley = RonWesley("Ron Wesley", 400, Action())
    val professorDumbeldor: ProfessorDumbeldor = ProfessorDumbeldor("Professor Dumbeldor", 400, Action())

    val lordvoldemord: LordVoldemord = LordVoldemord("Lord Voldemord", 700)
    val nagini: Nagini = Nagini("Nagini", 500)

    var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, professorDumbeldor)
    var gegener: MutableList<DunklerZauberer> = mutableListOf(lordvoldemord,nagini)


    var gameOver: Boolean = false
    // Rundencounter
    var round: Int = 1
    while (!gameOver) {
        println("------Runde:$round------")

        helden.forEach { println("Dein Team besteht aus ${it.name}")}
        println("-------------------------")
        gegener.forEach { println("Deine Gegner sind ${it.name}")}

        harryPotter.angriff(lordvoldemord)
        ronWesley.angriff(lordvoldemord)
        professorDumbeldor.angriff(lordvoldemord)
        lordvoldemord.randomAngriff(helden.random())

        if (lordvoldemord.hp<=100){
            println("Nagini macht  eine Attacke weil Voldemord zu schwach ist")
            nagini.dementorenAttacke(helden.random())
            nagini.fluchDesTodes(helden.random())
            nagini.dementorenAttacke(helden.random())
        }
        if ((harryPotter.hp<=0 && ronWesley.hp<=0 && professorDumbeldor.hp <=0)||(lordvoldemord.hp<=0 && nagini.hp<=0)) gameOver=true

        round++
    }
    println("Game Over")
}


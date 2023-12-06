fun main() {
    var harryPotter:HarryPotter=HarryPotter("Harry Potter",500,Action())
    var ronWesley:RonWesley=RonWesley("Ron Wesley",400,Action())

    var lordvoldemord:LordVoldemord=LordVoldemord("Lord Voldemord",1000)
    var nagini:Nagini=Nagini("Nagini",500)

    var helden:MutableList<Zauberer> = mutableListOf(harryPotter,ronWesley)
    var gegner:MutableList<DunklerZauberer> = mutableListOf(lordvoldemord,nagini)


    harryPotter.angriff(lordvoldemord)
    lordvoldemord.feuerSturm(harryPotter)
    lordvoldemord.fluchDesTodes(harryPotter)
    harryPotter.heilungsmethoden()
    harryPotter.fliegen(lordvoldemord)







}
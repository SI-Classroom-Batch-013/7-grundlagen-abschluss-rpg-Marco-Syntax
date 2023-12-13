// Zauberer und Gegner erstellt
val harryPotter: HarryPotter = HarryPotter("Harry Potter", 400, Action())
val ronWesley: RonWesley = RonWesley("Ron Wesley", 400, Action())
val albusDumbledore: AlbusDumbledore = AlbusDumbledore("Albus Dumbledore", 400, Action())

val lordVoldemort: LordVoldemort = LordVoldemort("Lord Voldemort", 600)
val nagini: Nagini = Nagini("Nagini", 300)

var helden: MutableList<Zauberer> = mutableListOf(harryPotter, ronWesley, albusDumbledore)
var gegner: MutableList<DunklerZauberer> = mutableListOf(lordVoldemort, nagini)

//Bedingung für Spiel Ende
var gameOver: Boolean = false
// Rundenzähler
var round: Int = 1
//Bedingung für Bonus Attacke
var naginiBonusAttacke = false
var naginiSchlangenBiss = false


fun main() {
    titelUeberschrift()
    spiel(helden,gegner)
}


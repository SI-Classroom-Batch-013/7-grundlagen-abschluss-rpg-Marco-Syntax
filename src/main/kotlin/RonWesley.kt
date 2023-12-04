class RonWesley(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()){

    //Kann ein Wandlungszauber anwenden und bekommt kein schaden

    var heiltrankAnwendungen = 3
    fun beutelTrank(auf: Zauberer) {
        if (heiltrankAnwendungen > 0) {
            // Frei wählbar! Einmal in jeder Runde verfügbar
            // Heilt den Zauber um die Hälfte seiner Lebenspunkte
            val heilung = auf.hp / 2
            auf.hp += heilung

            println("${auf.name} hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }
    fun vitamine(auf: Zauberer){
        var hp = hp / 100 * 10
        println("$name hat Vitamine genommen seine Energie wird dauerhaft um 10% erhöht ")
    }


}
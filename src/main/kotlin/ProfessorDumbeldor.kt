open class ProfessorDumbeldor(name: String, hp: Int, action: Action) : Zauberer(name, hp, Action()){

    //Ruf seinen Phönix und macht eine Feuerattacke

    var heiltrankAnwendungen = 3
    fun beutelTrank() {
        if (heiltrankAnwendungen > 0) {
            // Frei wählbar! Einmal in jeder Runde verfügbar
            // Heilt den Zauber um die Hälfte seiner Lebenspunkte
            val heilung = this.hp / 2
            this.hp += heilung

            println("${this.name} hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }
    fun vitamine(auf: Zauberer){
        var hp = this.hp / 100 * 10
        println("${this.name} hat Vitamine genommen seine Energie wird dauerhaft um 10% erhöht ")
    }

}

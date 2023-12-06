open class Beutel(name: String, hp: Int, action: Action, schutzZauberAktiv: Boolean = false) : Zauberer(name, hp, action, schutzZauberAktiv) {

    var heiltrankAnwendungen = 3

    open fun beutelTrank() {
        if (heiltrankAnwendungen > 0) {
            // Frei wählbar! Einmal in jeder Runde verfügbar
            // Heilt den Zauberer um die Hälfte seiner Lebenspunkte
            val heilung = hp / 2
            hp += heilung
            println("$name hat einen Heiltrank verwendet und wurde um $heilung Lebenspunkte geheilt.")
            heiltrankAnwendungen--
        } else {
            println("Der Heiltrank kann nicht mehr verwendet werden, er wurde bereits drei Mal eingesetzt.")
        }
    }

    open fun vitamine() {
        var hp = hp / 100 * 10
        println("$name hat Vitamine genommen seine Energie wird dauerhaft um 10% erhöht ")
    }

}
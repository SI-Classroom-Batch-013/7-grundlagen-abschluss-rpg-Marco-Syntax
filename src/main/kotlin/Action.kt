import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

open class Action {
    open val zaubersprueche: MutableMap<String, Int> = mutableMapOf(
        "expecto patronum" to  50,
        "stupor" to  100,
        "expelliarmus" to  150,
        "avada kedavra" to  200
    )
//Hier wird der Schaden von der map genommen man gibt den key ein und bekommt den Value wert als zauberSpruchschaden und man hat 3 versuche es wird über die readline eingeben
    open fun zauberSpruchAnwenden(zauberSpruchName: String): Int? {
        var zauberSpruchSchaden = zaubersprueche[zauberSpruchName]
        var versuche = 1

        while (zauberSpruchSchaden == null && versuche <= 3) {
            println("Bitte gib einen gültigen Zauberspruch ein: ")
            val benutzereingabe = readln()
            zauberSpruchSchaden = zaubersprueche[benutzereingabe]
            versuche++

            if (zauberSpruchSchaden == null && versuche <= 3) {
                println("Zauber: $benutzereingabe nicht gefunden. Versuch $versuche von 3.")
            }
        }
        if (zauberSpruchSchaden == null) {
            println("Drei Versuche wurden erreicht. Angriff wurde abgebrochen.")
        } else {
            println("${blue}Zauber: $zauberSpruchName, Schaden: $zauberSpruchSchaden hP$reset")
        }
        return zauberSpruchSchaden
    }
}


//Außerhalb der klasse
fun titelUeberschrift(){
    println(
        "$yellow                                        _ __\n" +
                "        ___                             | '  \\\n" +
                "   ___  \\ /  ___         ,'\\_           | .-. \\        /|\n" +
                "   \\ /  | |,'__ \\  ,'\\_  |   \\          | | | |      ,' |_   /|\n" +
                " _ | |  | |\\/  \\ \\ |   \\ | |\\_|    _    | |_| |   _ '-. .-',' |_   _\n" +
                "// | |  | |____| | | |\\_|| |__    //    |     | ,'_`. | | '-. .-',' `. ,'\\_\n" +
                "\\\\_| |_,' .-, _  | | |   | |\\ \\  //    .| |\\_/ | / \\ || |   | | / |\\  \\|   \\\n" +
                " `-. .-'| |/ / | | | |   | | \\ \\//     |  |    | | | || |   | | | |_\\ || |\\_|\n" +
                "   | |  | || \\_| | | |   /_\\  \\ /      | |`    | | | || |   | | | .---'| |\n" +
                "   | |  | |\\___,_\\ /_\\ _      //       | |     | \\_/ || |   | | | |  /\\| |\n" +
                "   /_\\  | |           //_____//       .||`      `._,' | |   | | \\ `-' /| |\n" +
                "        /_\\           `------'        \\ |          `.\\  | |  `._,' /_\\\n" +
                "                                       \\|    $reset DER MAGISCHE KAMPF           "
    )
    println()
    println("      ----Der Kampf Beginnt----")
}
fun audio (audiopath : String) {

    val audio: File = File(audiopath)

    val audioInput: AudioInputStream = AudioSystem.getAudioInputStream(audio)

    val clip: Clip = AudioSystem.getClip()

    clip.open(audioInput)

    clip.start()

    if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
        val volume: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl

        volume.value = volume.minimum+(0.75f*(volume.maximum-volume.minimum))
    } else {
        println("Master Gain Control not Supported")
    }
}
fun gameMusik(){
    val audiopath = "Sounds/Hedwig's Theme.wav"
    audio(audiopath)
}

//Gobale variabel
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val bold = "\u001B[1m"
val underline = "\u001B[4m"
val backgroundYellow = "\u001B[43m"
val reset = "\u001B[0m"





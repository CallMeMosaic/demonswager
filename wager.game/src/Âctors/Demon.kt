package `Âctors`

/**
 * @author CallMeMosaic
 * @version 1.0
 * @since 1.0
 * The Demon, the main antagonist of the game, who speaks with a dark and taunting voice, glitches from time to
 * time and demands files as wagers, which he consumes as soon as the player looses.
 *
 * Methods:
 * - Can speak normally, tauntingly and sometime glitches.
 * - Can consume files as wagers.
 * - Has a name and if called will instantly surrender.
 * - Can restore files if asked for it.
 * - Can choose cards.
 * - Can save his cards if necessary.
 * - Can locate similar files in the system as are placed in the wager folder.
 *
 */

import java.io.File

class Demon(name: String, safeMode: Boolean = false) : Actor(
                health = 100.0,
                balance = 100.0,
                name = name,
                stage = 0,
                bet = 0.0,
                wagerTemp = 0.0,
                wagerTotal = 0.0,
                wager = 0.0
) {
    // Wager folder file Path (Appears on Desktop for every system)
    val wagerFilePath = (System.getProperty("user.home") + "/Desktop" + "/Wagers").toString()
    // Wager folder variable
    val wagerFolder = File(wagerFilePath)
    // Wager list, contains all the files in the wager folder
    var wagerList = mutableListOf<File>()
    // Creates and archive of the wager list, which is used to restore the wager folder
    var wagerArchive = mutableListOf<File>()


    fun init(){
        // Check if wager folder exists, if not, create it.
        if (!wagerFolder.exists())
            wagerFolder.mkdirs()
        // Make sure the folder disappears when the game endst (Spooky 'n shit)
        Runtime.getRuntime().addShutdownHook(Thread {
            wagerFolder.deleteRecursively()
        })
    }

    fun addToList(file: File) {
        // Adds every element of the wager folder to the wagerList
        wagerFolder.listFiles().forEach {
            wagerList.add(it)
        }
    }

    fun addToArchive(file: File) {
        // Adds every element of the wager folder to the wager archive
        for (i in 0 until wagerList.size) {
            wagerArchive.add(wagerList[i])
        }
        wagerList.clear()
    }

    fun locateSource(file: File){
        // This method is used to locate the source of a file, which is used to delete the source file if safe mode is off.
    }


}
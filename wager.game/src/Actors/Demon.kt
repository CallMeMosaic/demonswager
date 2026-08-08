package Actors
/**
 * @author CallMeMosaic
 * @version 1.0
 * @since 1.0
 * The Demon, the main antagonist of the game, who speaks with a dark and taunting voice, glitches from time to
 * time and demands files as wagers, which he consumes as soon as the player looses.
 *
 * Methods:
 * - Can speak normally, tauntingly and sometimes glitches.
 * - Can consume files as wagers.
 * - Has a name and if called will instantly surrender.
 * - Can restore files if asked for it.
 * - Can choose cards.
 * - Can save his cards if necessary.
 * - Can locate similar files in the system as are placed in the wager folder.
 *
 * Heritage:
 * @see Actor
 * @see GlobalFunctions for communication
 */

import GlobalFunctions.Glitch
import GlobalFunctions.Talk
import GlobalFunctions.Taunt
import java.io.File
import java.nio.file.Paths
import java.util.Locale
import GlobalFunctions.GlobalPaths
import GlobalFunctions.LocateFile
import GlobalFunctions.RootPath

class Demon(name: String, safeMode: Boolean = false) : Actor(
    health = 100.0,
    balance = 100.0,
    name = name,
    stage = 0,
    bet = 0.0,
    wagerTemp = 0.0,
    wagerTotal = 0.0,
    wager = 0.0
), Talk, Taunt, Glitch, LocateFile{

    // Final Wager Folder variable
    val wagerFolder = File(System.getProperty("user.home") + "/Desktop" + "/Wagers")


    // Wager Archive folder variable. Automatically hides it for all OS
    val wagerArchiveFolder = File(
        System.getProperty("user.dir") + "/.WagerArchive"
    ).also {
        it.mkdirs()
        if (System.getProperty("os.name").lowercase().contains("win"))
            Runtime.getRuntime().exec(arrayOf("attrib", "+h", it.absolutePath))
    }


    // Wager list, contains all the files in the wager folder
    var wagerList = mutableListOf<File>()

    // Creates and archive of the wager list, which is used to restore the wager folder
    var wagerArchive = mutableListOf<File>()

    // Globals List
    val globals = listOf<String>(GlobalPaths.videos, GlobalPaths.desktop, GlobalPaths.documents, GlobalPaths.downloads,GlobalPaths.pictures)

    // Game Root
    val root = RootPath.rootPath()



    init {
        // Check if wager folder exists, if not, create it.
        if (!wagerFolder.exists())
            wagerFolder.mkdirs()
        // Make sure the folder disappears when the game endst (Spooky 'n shit)
        Runtime.getRuntime().addShutdownHook(Thread {
            wagerFolder.deleteRecursively()
            wagerArchiveFolder.deleteRecursively()
        })
    }


    /**
     * @author CallMeMosaic
     * Adds every element found inside the wager folder to the wagerList,
     * so the demon can reference them.
     * O-Notation: O(n)
     */
    fun addToList() {
        wagerFolder.listFiles()?.forEach {
            wagerList.add(it)
        }
    }


    fun locateSource(file: File, root: Boolean = false) : String? {
        // This method is used to locate the source of a file, which is used to delete the source file if safe mode is off.
        // IDENTIFY FILE VIA: NAME, SIZE, CONTENTS

        // Iterate through all the global paths and check if the file is present there.
        if (root){
            for (item in globals) {
                val result = locateFileByNameAndSize(file.name, file.length(), item, file.extension)
                if (result != null) return result
                else continue
            }
            val result = locateFileByNameAndSize(file.name,file.length(), this.root
                , file.extension)
            if (result != null) return result
            else return null
        }
        else{
            for (item in globals) {
                val result = locateFileByNameAndSize(file.name, file.length(), item, file.extension)
                if (result != null) return result
                else continue
            }
        }

        // Fallback to


        return null




    }


    /**
     * @author CallMeMosaic
     * Adds every element of the wagerList to the wagerArchive
     * and clears the wagerList, so it can be used with new wagers.
     * Also clears the wagerArchive priorly, so only the elements from the freshly ended
     * round are inside it.
     * O-Notation: O(n)
     */
    fun addToArchive() {

        // Clears archive before new assignment
        wagerArchive.clear()
        for (item in wagerArchiveFolder.listFiles()) item.delete()

        // Adds every element of the wager folder to the wager archive
        for (element in wagerList) {
            wagerArchive.add(element)
            element.copyTo(File(wagerArchiveFolder, element.name), true)
            element.delete()
        }
        wagerList.clear()


        // Archive reset needed here
    }

    fun terminateFile(file: File) = file.delete()


}
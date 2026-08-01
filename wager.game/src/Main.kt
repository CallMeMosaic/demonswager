import Actors.Demon
import Cards.CardBack
import GlobalFunctions.GlobalPaths
import java.io.File

fun main() {
    var game = Game()
    //var player = Player()
    var demon = Demon("Belial", true)
    var card = CardBack()
    card.printAnimated()
    println("ADD SHIT TO LIST AND PRESS ENTER AFTERWARDS")
    var temp = readln()


    // TEST MAIN METHODS OF DEMON

    var locatedFiles: MutableList<String?> = mutableListOf()




    demon.addToList()
    println("ADDING TO LIST")
    for(item in demon.wagerList) println(item)
    println("PRESS ENTER TO CONTINUE")
    temp = readln()
    //demon.locateSource(demon.wagerList[0])
    for(item in demon.wagerList)  locatedFiles.add(demon.locateSource(item))
    println("THIS SHOULD WORK")
    for(item in locatedFiles) println("FILE AT" + item)
    //println("FILE AT: " + demon.locateSource(demon.wagerList[0]))
    println("PRESS ENTER TO CONTINUE")
    temp = readln()
    demon.addToArchive()
    for(item in demon.wagerArchive) println(item)
    println("PRESS ENTER TO CONTINUE")
    temp = readln()
    println("NOW DELETING SOURCE FILES!")
    for(item in locatedFiles) demon.terminateFile(File(item))
    demon.addToArchive()
    println("PRESS ENTER TO EXIT")
    temp = readln()








}
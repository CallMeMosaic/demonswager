package GlobalFunctions


/*
This interace should be implemented by all classes that should be able to talk.
It will also have sub-interaces for each type of communication (glitching, taunting, LLM based).
This is important so later on in the game, each actor communicates the same way.
 */
interface Talk {
    fun talk(
        message: String,
    ){
        println(message)
    }

}

interface Taunt {
    fun taunt(
        message: String,
    ){
        println(message)
    }
}

interface Glitch {
    fun glitch(
        message: String,
    ){
        println(message)
    }
}
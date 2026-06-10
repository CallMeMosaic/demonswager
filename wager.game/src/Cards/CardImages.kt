package Cards

const val CARD_WIDTH = 5
const val CARD_HEIGHT = 12

sealed class CardImage(width: Int = CARD_WIDTH, height: Int = CARD_HEIGHT){
    protected abstract var image: Array<String>

    fun printAnimated(){
        for (line in image) println(line)//; Thread.sleep(200)
    }
}

class CardBack: CardImage(){
    override var image: Array<String> = arrayOf(
        ".-------------------.",
        "|         *         |",
        "|       *   *       |",
        "|      * (*) *      |",
        "|     *       *     |",
        "|     *       *     |",
        "|      * (*) *      |",
        "|       *   *       |",
        "|         *         |",
        "'\'___________________/"

    )
    init {

    }


}
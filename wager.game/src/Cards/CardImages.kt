package Cards

const val CARD_WIDTH = 5
const val CARD_HEIGHT = 12

sealed class CardImage(width: Int = CARD_WIDTH, height: Int = CARD_HEIGHT){
    var image = Array(width, { Array(height, { "" }) })
    var image2 = mutableListOf<Array<String>>()
    var image3 = mutableListOf<String>()
}

class CardBack: CardImage(){
    init {
        super.image = Array(CARD_WIDTH, { Array(CARD_HEIGHT, { "card_back.png" }) })
        //super.image2.add("_")
        super.image3.add("_")
    }
}
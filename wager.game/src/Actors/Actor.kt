package Actors

open class Actor(
    var health: Double,
    var balance: Double,
    val name: String,
    var stage: Int,
    var bet: Double,
    var wagerTemp: Double,
    var wagerTotal: Double,
    var wager: Double
) {
    fun speak(text: String) = println("$name: $text")
}
import Archive.Actor

class Player(
    health: Double,
    balance: Double,
    name: String?,
    stage: Int,
    bet: Double,
    wager_temp: Double,
    wager_total: Double,
    wager: Double
) : Actor(health, balance, name, stage, bet, wager_temp, wager_total, wager)
package machine

abstract class Coffee {
    abstract val coffeeType: CoffeeType
    abstract val water : Int
    abstract val coffeeBeans : Int
    abstract val price : Int
    abstract val milk: Int
    val cups = 1
}
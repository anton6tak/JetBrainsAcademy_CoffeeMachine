package machine

class Cappuccino : Coffee() {
    override val coffeeType = CoffeeType.CAPPUCCINO
    override val water = 200
    override val coffeeBeans = 12
    override val price = 6
    override val milk = 100
}
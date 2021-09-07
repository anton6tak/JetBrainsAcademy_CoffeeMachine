package machine

class Latte : Coffee() {
    override val coffeeType = CoffeeType.LATTE
    override val water = 350
    override val coffeeBeans = 20
    override val price = 7
    override val milk = 75
}
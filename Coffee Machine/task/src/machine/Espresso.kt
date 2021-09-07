package machine

class Espresso : Coffee() {
    override val coffeeType = CoffeeType.ESPRESSO
    override val water = 250
    override val coffeeBeans = 16
    override val price = 4
    override val milk = 0
}
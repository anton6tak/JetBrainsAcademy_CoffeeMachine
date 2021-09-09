package machine

class CoffeeMachine(
    water: Int, milk: Int, coffeeBeans: Int, cups: Int, money: Int,
) {
    var water = water
    var milk = milk
    var coffeeBeans = coffeeBeans
    var cups = cups
    var money = money
    var state = CoffeeMachineState.CHOOSING_AN_ACTION

    fun setState(action : String){
        state = when(action){
            "buy" -> CoffeeMachineState.BUY
            "fill" -> CoffeeMachineState.FILL
            "take" -> CoffeeMachineState.TAKE
            "remaining" -> CoffeeMachineState.REMAINING
            "1", "2", "3" -> CoffeeMachineState.MAKE_COFEE
            else -> CoffeeMachineState.CHOOSING_AN_ACTION
        }

    }

    fun printInfo() {
        println()
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
        println()
    }

    fun makeCoffee(coffee: Coffee) {
        if (water < coffee.water)
            println("Sorry, not enough water!")
        else if (milk < coffee.milk)
            println("Sorry, not enough milk!")
        else if (coffeeBeans < coffee.coffeeBeans)
            println("Sorry, not enough coffee beans!")
        else if (cups < coffee.cups)
            println("Sorry, not enough cups!")
        else {
            println("I have enough resources, making you a coffee!")
            water -= coffee.water
            milk -= coffee.milk
            coffeeBeans -= coffee.coffeeBeans
            cups -= coffee.cups
            money += coffee.price
        }
        println()
    }

    fun fill() {
        print("Write how many ml of water do you want to add: ")
        water += readLine()?.toInt() ?: 0
        print("Write how many ml of milk do you want to add: ")
        milk += readLine()?.toInt() ?: 0
        print("Write how many grams of coffee beans do you want to add: ")
        coffeeBeans += readLine()?.toInt() ?: 0
        print("Write how many disposable cups of coffee do you want to add: ")
        cups += readLine()?.toInt() ?: 0
        println()
    }

    fun take() {
        println()
        println("I gave you $$money")
        money = 0
        println()
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        var choice = readLine()
        if (choice == "back")
            return
        println()
        when (choice?.toInt()) {
            1 -> makeCoffee(Espresso())
            2 -> makeCoffee(Latte())
            3 -> makeCoffee(Cappuccino())
        }
    }

    fun start() {
        while (true) {
            print("Write action (buy, fill, take, remaining, exit): ")
            var action = readLine()
            if (action != null) {
                setState(action)
            }
            when (action) {
                "buy" -> {
                    buy()
                }
                "fill" -> {
                    fill()
                }
                "take" -> {
                    take()
                }
                "remaining" -> {
                    printInfo()
                }
                "exit" -> {
                    return
                }
                else -> {
                }
            }
        }
    }
}
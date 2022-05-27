package Strategy

class Context(strategy: Strategy) {
    private val strategy: Strategy

    init {
        this.strategy = strategy
    }

    fun executeStrategy(num1: Int, num2: Int): Int {
        return strategy.doOperation(num1, num2)
    }
}
package Strategy

class OperationMultiply : Strategy{
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}
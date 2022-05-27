package Singleton

object SingletonTestCase {
    fun booleanMessage(message: String): Boolean {
        return Singleton.Instance!!.newMessage() == message
    }

    fun allCreatedInstanceIsSame(singleton1: Singleton, singleton2: Singleton): Boolean {
        return singleton1 == singleton2
    }

    fun objectExists(): Singleton? {
        return Singleton.Instance
    }

    val isSame: Boolean
        get() {
            val singleton1 = Singleton.Instance
            val singleton2 = Singleton.Instance
            return singleton1 == singleton2
        }
}
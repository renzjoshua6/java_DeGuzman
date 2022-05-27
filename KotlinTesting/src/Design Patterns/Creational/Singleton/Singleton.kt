package Singleton

class Singleton  //make the constructor private so that this class cannot be //instantiated
// Exists only to defeat instantiation.
private constructor() {
    fun newMessage(): String {
        return "This is a Singleton"
    }

    companion object {
        private val newInstance: Singleton? = null;

        //create an object of SingleObject
        var Instance: Singleton? = null

        init {
            val newInstance = Singleton()
            Instance = Singleton.newInstance
        }
    }
}
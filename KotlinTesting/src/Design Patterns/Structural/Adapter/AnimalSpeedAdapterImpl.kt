package designpatterns.structural.adapter

class AnimalSpeedAdapterImpl(private val animals: AnimalSpeed) : AnimalSpeedAdapter {
    override val speed: Double
        get() = convertMPHtoKPH(animals.speed)

    private fun convertMPHtoKPH(mph: Double): Double {
        return mph * 1.60934
    }
}
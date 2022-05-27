package test.structural

import designpatterns.structural.adapter.AnimalSpeed
import designpatterns.structural.adapter.Cheetah
import designpatterns.structural.adapter.AnimalSpeedAdapter
import designpatterns.structural.adapter.AnimalSpeedAdapterImpl
import designpatterns.structural.adapter.BlackMarlin
import designpatterns.structural.adapter.HouseFly
import designpatterns.structural.adapter.PeregrineFalcon
import org.junit.Assert
import org.junit.Test

class TestStructural {
    @Test
    fun testCheetah() {
        val cheetah: AnimalSpeed = Cheetah()
        val cheetahAdapter: AnimalSpeedAdapter = AnimalSpeedAdapterImpl(cheetah)
        Assert.assertEquals(cheetahAdapter.speed, 96.5604, 0.00001)
    }

    @Test
    fun testBlackMarlin() {
        val blackMarlin: AnimalSpeed = BlackMarlin()
        val blackMarlinAdapter: AnimalSpeedAdapter = AnimalSpeedAdapterImpl(blackMarlin)
        Assert.assertEquals(blackMarlinAdapter.speed, 128.7472, 0.00001)
    }

    @Test
    fun testHouseFly() {
        val houseFly: AnimalSpeed = HouseFly()
        val houseFlyAdapter: AnimalSpeedAdapter = AnimalSpeedAdapterImpl(houseFly)
        Assert.assertEquals(houseFlyAdapter.speed, 144.8406, 0.00001)
    }

    @Test
    fun testPeregrineFalcon() {
        val peregrineFalcon: AnimalSpeed = PeregrineFalcon()
        val peregrineFalconAdapter: AnimalSpeedAdapter = AnimalSpeedAdapterImpl(peregrineFalcon)
        Assert.assertEquals(peregrineFalconAdapter.speed, 241.401, 0.00001)
    }
}
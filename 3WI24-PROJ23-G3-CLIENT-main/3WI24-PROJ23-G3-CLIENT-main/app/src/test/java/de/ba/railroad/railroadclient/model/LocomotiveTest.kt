package de.ba.railroad.railroadclient.model

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class LocomotiveTest {

    @Test
    fun testSerialization() {
        val locomotive = Locomotive(
            id = "123",
            speed = 55,
            direction = Direction.DIRECTION_FORWARD,
            number = "789",
            name = "Thomas",
            isHeadLight = true,
            isCabinLighting = true,
            isHornSound = false,
            isDrivingSound = true,
            isSmoking = false,
            position = 10
        )

        val json = Json { encodeDefaults = true }
        val output = json.encodeToString(Locomotive.serializer(), locomotive)
        val expectedJson = """{"id":"123","speed":55,"direction":0,"number":"789","name":"Thomas","headLight":true,"cabineLighting":true,"hornSound":false,"drivingSound":true,"smoking":false,"position":10}"""
        assertEquals(expectedJson, output)
    }

    @Test
    fun testDeserialization() {
        val json = Json { encodeDefaults = true }
        val inputJson = """{"id":"123","speed":55,"direction":0,"number":"789","name":"Thomas","headLight":true,"cabineLighting":true,"hornSound":false,"drivingSound":true,"smoking":false,"position":10}"""
        val locomotive = json.decodeFromString(Locomotive.serializer(), inputJson)

        assertEquals("123", locomotive.id)
        assertEquals(55, locomotive.speed)
        assertEquals(Direction.DIRECTION_FORWARD, locomotive.direction)
        assertEquals("789", locomotive.number)
        assertEquals("Thomas", locomotive.name)
        assertEquals(true, locomotive.isHeadLight)
        assertEquals(true, locomotive.isCabinLighting)
        assertEquals(false, locomotive.isHornSound)
        assertEquals(true, locomotive.isDrivingSound)
        assertEquals(false, locomotive.isSmoking)
        assertEquals(10, locomotive.position)
    }
}

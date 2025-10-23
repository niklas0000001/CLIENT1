package de.ba.railroad.railroadclient.model

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class ServerTest {

    @Test
    fun testSerialization() {
        val server = Server(
            url = "https://example.com",
            videoURL = "https://example.com/video",
            name = "Test Server"
        )

        val json = Json { encodeDefaults = true }
        val output = json.encodeToString(Server.serializer(), server)
        val expectedJson = """{"url":"https://example.com","videoURL":"https://example.com/video","name":"Test Server"}"""
        assertEquals(expectedJson, output)
    }

    @Test
    fun testDeserialization() {
        val jsonInput = """{"url":"https://example.com","videoURL":"https://example.com/video","name":"Test Server"}"""
        val json = Json { encodeDefaults = true }
        val server = json.decodeFromString(Server.serializer(), jsonInput)

        assertEquals("https://example.com", server.url)
        assertEquals("https://example.com/video", server.videoURL)
        assertEquals("Test Server", server.name)
    }
}

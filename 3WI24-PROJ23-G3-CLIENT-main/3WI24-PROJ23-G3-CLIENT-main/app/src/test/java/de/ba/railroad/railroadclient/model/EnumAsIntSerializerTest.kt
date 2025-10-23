package de.ba.railroad.railroadclient.model

import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

enum class SampleEnum {
    FIRST, SECOND, THIRD
}

val sampleEnumSerializer = EnumAsIntSerializer(
    serialName = "SampleEnum",
    serialize = { it.ordinal },
    deserialize = { SampleEnum.values()[it] }
)

class EnumAsIntSerializerTest {
    @Test
    fun testSerialization() {
        val encoder: Encoder = mock()

        // Testing serialization
        sampleEnumSerializer.serialize(encoder, SampleEnum.SECOND)
        verify(encoder).encodeInt(1)  // Assuming ordinal starts at 0
    }

    @Test
    fun testDeserialization() {
        val decoder: Decoder = mock()
        whenever(decoder.decodeInt()).thenReturn(2)  // Corresponds to THIRD

        // Testing deserialization
        val result = sampleEnumSerializer.deserialize(decoder)
        assertEquals(SampleEnum.THIRD, result)
    }
}
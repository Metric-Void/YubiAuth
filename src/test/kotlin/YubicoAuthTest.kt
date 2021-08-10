import com.metricv.yubiauth.yubiapi.HMACSHA1
import com.metricv.yubiauth.yubiapi.Yubico
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class YubicoAuthTest() {
    @Test
    fun testNonce() {
        val nonceRule = Regex("[A-Za-z0-9]{16,40}")
        repeat(1000) {
            assertTrue(Yubico.randomNonce().matches(nonceRule));
        }
    }

    @Test
    fun testVectorRequest() {
        val map = mapOf(
            "id" to "1",
            "otp" to "vvungrrdhvtklknvrtvuvbbkeidikkvgglrvdgrfcdft",
            "nonce" to "jrFwbaYFhn0HoxZIsd9LQ6w2ceU"
        )
        assertEquals("+ja8S3IjbX593/LAgTBixwPNGX4=", HMACSHA1.encryptParamList(map, "mG5be6ZJU1qBGz24yPh/ESM3UdU="))
    }

    @Test
    fun testVectorResponse() {
        val map = mapOf(
            "status" to "OK",
            "t" to "2019-06-06T05:14:15Z0369",
            "nonce" to "0123456789abcdef",
            "otp" to "cccccckdvvulethkhtvkrtbeukiettvfceekurncllcj",
            "sl" to "25"
        )
        assertEquals("iCV9uFJDtuyELQsxFPnR80Yj2XU=", HMACSHA1.encryptParamList(map, "mG5be6ZJU1qBGz24yPh/ESM3UdU="))
    }
}
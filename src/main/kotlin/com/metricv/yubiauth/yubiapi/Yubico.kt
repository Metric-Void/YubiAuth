package com.metricv.yubiauth.yubiapi

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import java.lang.Math.random

object Yubico {
    var clientId: Int? = null;
    var clientSecret: String? = null;
    val alphaNumeric = ('A'..'Z').toList() + ('a'..'z').toList() + ('0'..'9').toList();

    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    };

    fun getYubicoObject(clientId: Int, clientSecret: String): Yubico {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        return this;
    }

    fun randomNonce(): String {
        val length: Int = (16 + random() * 24).toInt();
        return (1..length).map { alphaNumeric.random() }.joinToString("")
    }

    /**
     * Send a request to YubiCloud, verify the integrity of an OTP.
     * @param OTP The One Time Password to be verified.
     */
    suspend fun verifyOTP(otp: String): String {
        val nonce: String = randomNonce();
        val response = client.get<HttpResponse>("https://api.yubico.com/wsapi/2.0/verify") {
            parameter("id", clientId.toString())
            parameter("nonce", nonce)
            parameter("otp", otp)
        }
        val content: ByteArray = response.receive();
        return content.decodeToString();
    }
}
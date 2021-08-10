package com.metricv.yubiauth.yubiapi

import java.util.*
import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import kotlin.streams.toList

class HMACSHA1 {
    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     * @return
     * @throws Exception
     */
    companion object {
        private const val MAC_NAME = "HmacSHA1"
        private const val ENCODING = "UTF-8"

        /**
         * Encrypt a list of HTTP request/response parameters.
         * The list of parameters will be sorted alphabetically and encrypted with the base64 key.
         * Encryption result will also be encoded as Base64 format.
         * @param paramMap A map containing all the parameters.
         * @param encryptKeyBase64 The encryption key in Base64.
         * @return Encryption result in Base64 string format.
         */
        fun encryptParamList(paramMap : Map<String, String>, encryptKeyBase64: String) : String {
            val paramString = paramMap.toSortedMap().toList().stream().map {
                "${it.first}=${it.second}"
            }.toList().joinToString("&")
            return hmacSHA1EncryptBase64(paramString, encryptKeyBase64)
        }

        fun hmacSHA1EncryptBase64(encryptText: String, encryptKey: String): String {
            val key = Base64.getDecoder().decode(encryptKey)
            val hmacResult = hmacSHA1Encrypt(encryptText, key);
            return Base64.getEncoder().encodeToString(hmacResult);
        }

        fun hmacSHA1Encrypt(encryptText: String, encryptKey: ByteArray): ByteArray {
            val secretKey: SecretKey = SecretKeySpec(encryptKey, MAC_NAME)
            val mac = Mac.getInstance(MAC_NAME)
            mac.init(secretKey)
            val text = encryptText.toByteArray(charset(ENCODING))
            return mac.doFinal(text)
        }
    }
}
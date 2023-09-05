package com.roanderson.design_compose.utils

import android.os.Build
import androidx.annotation.RequiresApi
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

class CryptoUtils {
    companion object {
        private const val ALGORITHM = "AES"
        private const val TRANSFORMATION = "AES/ECB/PKCS5Padding"
        private const val CHARSET = "UTF-8"

        @RequiresApi(Build.VERSION_CODES.O)
        fun encrypt(key: String, data: String): String {
            val secretKey = SecretKeySpec(key.toByteArray(Charsets.UTF_8), ALGORITHM)
            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encryptedBytes = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedBytes)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun decrypt(key: String, encryptedData: String): String {
            val secretKey = SecretKeySpec(key.toByteArray(Charsets.UTF_8), ALGORITHM)
            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(Cipher.DECRYPT_MODE, secretKey)
            val encryptedBytes = Base64.getDecoder().decode(encryptedData)
            val decryptedBytes = cipher.doFinal(encryptedBytes)
            return String(decryptedBytes, Charsets.UTF_8)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val key = "MySecretKey12345"
    val data = "Texto para criptografar"

    val encryptedData = CryptoUtils.encrypt(key, data)
    println("Texto criptografado: $encryptedData")

    val decryptedData = CryptoUtils.decrypt(key, encryptedData)
    println("Texto descriptografado: $decryptedData")
}

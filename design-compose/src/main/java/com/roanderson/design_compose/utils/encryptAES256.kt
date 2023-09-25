package com.roanderson.design_compose.utils

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

fun String.encryptAES256(): ByteArray? {
    try {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val secretKey = getSecretKey()
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        return cipher.doFinal(this.toByteArray(Charsets.UTF_8))
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun ByteArray.decryptAES256(): String? {
    try {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val secretKey = getSecretKey()
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decryptedBytes = cipher.doFinal(this)
        return String(decryptedBytes, Charsets.UTF_8)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

private fun getSecretKey(): SecretKey {
    val keyStore = KeyStore.getInstance("AndroidKeyStore")
    keyStore.load(null)
    if (!keyStore.containsAlias("my_key_alias")) {
        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore"
        )
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            "my_key_alias",
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()
        keyGenerator.init(keyGenParameterSpec)
        keyGenerator.generateKey()
    }
    return keyStore.getKey("my_key_alias", null) as SecretKey
}

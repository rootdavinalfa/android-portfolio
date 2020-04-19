package com.davin.davin_myportfolio.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class AssetParser {
    /**
     * Asset Parser getImageAsset
     * @param context requester context
     * @param filename location of file
     * @return image byte array
     * */
    fun getImageAsset(context: Context, filename: String): ByteArray? {
        return try {
            val `is`: InputStream = context.assets.open(filename)

            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            buffer
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Asset Parser getJsonAssets
     * @param context requester context
     * @param filename location of file
     * @return json string
     * */
    fun getJsonAssets(context: Context, filename: String): String? {
        val jsonString: String
        try {
            val `is`: InputStream = context.assets.open(filename)

            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            jsonString = String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}
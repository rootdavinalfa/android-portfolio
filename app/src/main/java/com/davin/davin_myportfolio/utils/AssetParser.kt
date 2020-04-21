/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 * Class Helper for AssetParser
 */


package com.davin.davin_myportfolio.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class AssetParser {
    /**
     * Asset Parser for getting Image in ByteArray,use it with your favorite ImageLoader
     *
     *  [context] requester context
     *
     *  [filename] location of file
     *
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
     * Asset Parser for getting Json String will returning jsonString
     *
     * [context] requester context
     *
     * [filename] location of file
     *
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
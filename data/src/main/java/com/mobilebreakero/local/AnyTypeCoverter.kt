package com.mobilebreakero.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class AnyTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromJsonString(json: String): Any? {
        return gson.fromJson(json, Any::class.java)
    }

    @TypeConverter
    fun toJsonString(any: Any?): String {
        return gson.toJson(any)
    }
}

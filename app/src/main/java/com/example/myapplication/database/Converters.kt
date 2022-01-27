package com.example.myapplication.database

import androidx.room.TypeConverter
import java.time.LocalDateTime
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class Converters {
    @TypeConverter
    fun fromList(value: List<Pair<Double, Double>>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<Pair<Double, Double>>>(value)

    @TypeConverter
    fun fromDate(date: LocalDateTime) = date.toString()

    @TypeConverter
    fun toDate(date: String) = LocalDateTime.parse(date)
}
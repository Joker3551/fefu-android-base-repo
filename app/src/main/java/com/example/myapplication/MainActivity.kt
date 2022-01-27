package com.example.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.myapplication.database.ActivityDatabase


class MainActivity : Application() {
    companion object{
        lateinit var INSTANCE: MainActivity
    }
    val db: ActivityDatabase by lazy {
        Room.databaseBuilder(
            this,
            ActivityDatabase::class.java,
            "activity_database"
        ).allowMainThreadQueries().build()
    }
}
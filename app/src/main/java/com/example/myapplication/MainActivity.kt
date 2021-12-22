package com.example.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : Application() {
    companion object{
        lateinit var INSTANCE: MainActivity
    }

}
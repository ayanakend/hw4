package com.example.myapplication

import android.app.Application
import androidx.room.Room
import com.example.myapplication.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object{
        lateinit  var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_table")
            .allowMainThreadQueries().build()
    }
}
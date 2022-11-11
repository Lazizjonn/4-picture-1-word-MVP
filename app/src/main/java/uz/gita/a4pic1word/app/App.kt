package uz.gita.a4pic1word.app

import android.app.Application
import uz.gita.a4pic1word.data.local.MySharedPreferences
import uz.gita.a4pic1word.data.repository.Repository


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // init repository
        Repository.initRepository()

        // shared preferences
        MySharedPreferences.init(this)
    }
}
package com.alya.youtubeapi

import android.app.Application
import com.alya.youtubeapi.repozitory.Repozitory

class App : Application() {
    companion object {
        val repozitory: Repozitory by lazy {
            Repozitory()
        }
    }
}
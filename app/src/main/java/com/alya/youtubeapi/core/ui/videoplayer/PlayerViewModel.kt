package com.alya.youtubeapi.core.ui.videoplayer

import androidx.lifecycle.LiveData
import com.alya.youtubeapi.App
import com.alya.youtubeapi.core.network.result.Resource
import com.alya.youtubeapi.core.ui.BaseViewModel
import com.alya.youtubeapi.data.remote.model.Playlists

class PlayerViewModel : BaseViewModel() {
    fun getVideo(id: String): LiveData<Resource<Playlists>> {
        return App.repozitory.getVideoPlayer(id)
    }
}
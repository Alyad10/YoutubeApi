package com.alya.youtubeapi.core.ui.playlists

import androidx.lifecycle.LiveData
import com.alya.youtubeapi.App.Companion.repozitory
import com.alya.youtubeapi.core.network.result.Resource
import com.alya.youtubeapi.core.ui.BaseViewModel
import com.alya.youtubeapi.data.remote.model.Playlists

open class PlaylistsViewModel: BaseViewModel() {


    fun getplaylist(): LiveData<Resource<Playlists>> {
        return repozitory.getPlayLists()
    }




}


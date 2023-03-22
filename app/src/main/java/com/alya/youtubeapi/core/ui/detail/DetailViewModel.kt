package com.alya.youtubeapi.core.ui.detail

import androidx.lifecycle.LiveData
import com.alya.youtubeapi.App
import com.alya.youtubeapi.core.network.result.Resource
import com.alya.youtubeapi.core.ui.BaseViewModel
import com.alya.youtubeapi.data.remote.model.PlaylistItem
open class DetailViewModel : BaseViewModel() {

    fun itemList(id: String): LiveData<Resource<PlaylistItem>> {
        return App.repozitory.getItemList(id = id)
    }
}
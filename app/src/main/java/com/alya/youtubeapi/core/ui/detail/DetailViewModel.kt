package com.alya.youtubeapi.core.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alya.youtubeapi.App
import com.alya.youtubeapi.BuildConfig
import com.alya.youtubeapi.core.ui.BaseViewModel
import com.alya.youtubeapi.data.remote.model.PlaylistItem
import com.alya.youtubeapi.data.remote.ApiService
import com.alya.youtubeapi.core.network.RetrofitClient
import com.alya.youtubeapi.core.network.result.Resource
import com.alya.youtubeapi.data.remote.model.Localized
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class DetailViewModel : BaseViewModel() {

    fun itemList(id: String): LiveData<PlaylistItem>{
        return App.repozitory.getItemList(id = id)

    }
}
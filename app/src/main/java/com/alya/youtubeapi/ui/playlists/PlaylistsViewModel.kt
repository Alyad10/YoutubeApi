package com.alya.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alya.youtubeapi.BuildConfig
import com.alya.youtubeapi.model.Playlists
import com.alya.youtubeapi.base.BaseViewModel
import com.alya.youtubeapi.model.PlaylistItem
import com.alya.youtubeapi.remote.ApiService
import com.alya.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class PlaylistsViewModel: BaseViewModel() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlist(): LiveData<Playlists> {
        return getPlayLists()
    }

    private fun getPlayLists(): LiveData<Playlists> {
        val data = MutableLiveData<Playlists>()
        apiService.getPlaylists(
            com.alya.youtubeapi.BuildConfig.API_KEY,
            "UCWOA1ZGywLbqmigxE4Qlvuw",
            "snippet,contentDetails",
            50
        )
            .enqueue(object : Callback<Playlists> {
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {

                    print(t.message)
                }

            })
        return data
    }


}


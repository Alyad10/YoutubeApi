package com.alya.youtubeapi.data.remote

import com.alya.youtubeapi.BuildConfig
import com.alya.youtubeapi.core.network.BaseDataSource
import com.alya.youtubeapi.core.network.RetrofitClient
import com.alya.youtubeapi.core.network.result.Resource
import com.alya.youtubeapi.data.remote.model.PlaylistItem
import com.alya.youtubeapi.data.remote.model.Playlists

class RemoteDataSource : BaseDataSource() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }


    suspend fun getPlayLists(): Resource<Playlists>{
        return getResult {
            apiService.getPlaylists(
                BuildConfig.API_KEY,
                "UCWOA1ZGywLbqmigxE4Qlvuw",
                "snippet,contentDetails",
                50)

        }
    }
    suspend fun getItemList(id: String) : Resource<PlaylistItem>{
        return getResult {
            apiService.getItemLists(
                BuildConfig.API_KEY,
                "snippet,contentDetails",
                50,
                id
            )
        }
    }
    suspend fun getVideoPlayer(id: String): Resource<Playlists>{
        return getResult {
            apiService.getVideo(
                BuildConfig.API_KEY,
                "snippet,contentDetails",
                id

            )
        }
    }
}
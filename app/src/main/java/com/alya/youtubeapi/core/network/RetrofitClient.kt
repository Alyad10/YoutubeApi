package com.alya.youtubeapi.core.network
import com.alya.youtubeapi.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        fun create(): ApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient = OkHttpClient.Builder().writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder().baseUrl(com.alya.youtubeapi.BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
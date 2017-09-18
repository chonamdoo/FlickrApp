package com.cho.githubsearch.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by chonamdoo on 2017. 9. 16..
 */

object FlickrApi {
    private val SERVER_CONNTECT_TIME: Long = 10000
    private val API_SERVER_URL = "https://api.flickr.com/services/rest/"

    val reqService: RequestService by lazy {
        initRequestService(httpClient(),API_SERVER_URL)
    }

    private fun initRequestService(httpClient: OkHttpClient,url : String): RequestService {
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create<RequestService>(RequestService::class.java)
    }

    private fun httpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
                .readTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .connectTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor).build()
    }
}
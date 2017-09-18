package com.cho.githubsearch.api

import com.cho.githubsearch.BuildConfig
import com.cho.githubsearch.data.model.PhotosContainer
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by chonamdoo on 2017. 9. 16..
 */

interface RequestService{
    @GET("?method=flickr.photos.search&format=json&privacy_filter=1&nojsoncallback=1&safe_search=1&api_key=${BuildConfig.FLICKR_API_KEY}")
    fun searchPhoto(
            @Query(value = "text", encoded = true) searchKeyword: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int): Single<PhotosContainer>
}
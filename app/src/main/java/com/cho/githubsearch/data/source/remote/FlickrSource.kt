package com.cho.githubsearch.data.source.remote

import com.cho.githubsearch.data.model.Photo
import io.reactivex.Single

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

interface FlickrSource{
    fun getPhotos(page : Int ,perPage: Int): Single<List<Photo>>
}
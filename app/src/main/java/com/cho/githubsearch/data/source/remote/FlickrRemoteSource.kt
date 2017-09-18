package com.cho.githubsearch.data.source.remote

import com.cho.githubsearch.api.FlickrApi
import com.cho.githubsearch.data.model.Photo
import io.reactivex.Single

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

object FlickrRemoteSource : FlickrSource{
    override fun getPhotos(page: Int, perPage: Int): Single<List<Photo>> =
            FlickrApi.reqService.searchPhoto("seoul",page,perPage)
                    .flatMap {
                        if(it.photos.photo.isNotEmpty()){
                            Single.just(it.photos.photo)
                        }else{
                            Single.just(ArrayList())
                        }
                    }
}
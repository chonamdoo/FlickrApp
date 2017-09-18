package com.cho.githubsearch.ui.gallery.viewmodel

import com.cho.githubsearch.data.model.Photo
import com.cho.githubsearch.data.source.remote.FlickrRepository
import com.cho.githubsearch.ui.base.BaseActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

class GalleryViewModel(private val activity : BaseActivity ,private val repository : FlickrRepository){
    lateinit var showProgress:()->Unit
    lateinit var hideProgress:()->Unit
    lateinit var addItem:(List<Photo>)->Unit
    private val PER_PAGE = 20
    fun fetchPhotoList(page : Int){
        repository.getPhotos(page,PER_PAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(activity,ActivityEvent.DESTROY)
                .doOnSubscribe {
                    if(page == 1) {
                        showProgress()
                    }
                }
                .doFinally{
                    hideProgress()
                }
                .subscribe({
                    addItem(it)
                },{})
    }
}
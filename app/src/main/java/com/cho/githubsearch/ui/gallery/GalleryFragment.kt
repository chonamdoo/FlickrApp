package com.cho.githubsearch.ui.gallery

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.cho.githubsearch.R
import com.cho.githubsearch.data.source.remote.FlickrRepository
import com.cho.githubsearch.extentions.isVisible
import com.cho.githubsearch.ui.base.BaseFragment
import com.cho.githubsearch.ui.gallery.viewmodel.GalleryViewModel
import com.cho.githubsearch.ui.widget.adapter.LoadMoreAdapter
import com.cho.githubsearch.ui.widget.listener.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_gallery.*

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

class GalleryFragment : BaseFragment(){
    private var page = 0
    private lateinit var activity : GalleryActivity

    private val viewModel : GalleryViewModel by lazy {
        GalleryViewModel(activity,FlickrRepository)
    }

    private val galleryAdapter : LoadMoreAdapter by lazy {
        LoadMoreAdapter()
    }
    override fun getLayoutResource(): Int = R.layout.fragment_gallery
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as GalleryActivity
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showProgress = {
            loading_progress.isVisible = true
        }
        viewModel.hideProgress={
            loading_progress.isVisible = false

        }
        viewModel.addItem ={
            galleryAdapter.addItems(it)
            galleryAdapter.notifyDataSetChanged()
        }
        recyclerview.apply {
            setHasFixedSize(true)
            val staggerLayout = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            val linearLayout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            layoutManager = staggerLayout
            adapter = galleryAdapter
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ reqPhoto() }, staggerLayout))
        }
        reqPhoto()


    }
    private fun reqPhoto(){
        viewModel.fetchPhotoList(++page)
    }
    companion object {
        val INSTANCE : GalleryFragment by lazy {
            GalleryFragment()
        }
    }

}
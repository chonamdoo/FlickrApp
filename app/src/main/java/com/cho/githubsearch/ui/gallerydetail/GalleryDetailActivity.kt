package com.cho.githubsearch.ui.gallerydetail

import android.os.Bundle
import com.cho.githubsearch.R
import com.cho.githubsearch.extentions.TAG
import com.cho.githubsearch.extentions.replaceFragmentToActivity
import com.cho.githubsearch.ui.base.BaseActivity
import com.cho.immersivedetail.util.LollipopCompatSingleton

/**
 * Created by chonamdoo on 2017. 9. 19..
 */

class GalleryDetailActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        LollipopCompatSingleton.translucentStatusBar(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_detail)
        replaceFragmentToActivity(R.id.content_frame,GalleryDetailFragment.INSTANCE(intent.extras),
                GalleryDetailFragment.TAG)
    }
}
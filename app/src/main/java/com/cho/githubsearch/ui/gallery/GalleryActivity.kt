package com.cho.githubsearch.ui.gallery

import android.os.Bundle
import com.cho.githubsearch.R
import com.cho.githubsearch.extentions.TAG
import com.cho.githubsearch.extentions.replaceFragmentToActivity
import com.cho.githubsearch.ui.base.BaseActivity

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

class GalleryActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        setArrowToolbar(getString(R.string.app_name))
        replaceFragmentToActivity(R.id.contentFrame,GalleryFragment.INSTANCE,GalleryFragment.TAG)
    }
}
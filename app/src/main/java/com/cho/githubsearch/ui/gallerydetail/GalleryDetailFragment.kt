package com.cho.githubsearch.ui.gallerydetail

import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.cho.githubsearch.R
import com.cho.githubsearch.extentions.loadImg
import com.cho.githubsearch.ui.base.BaseFragment
import com.cho.immersivedetail.util.LollipopCompatSingleton
import kotlinx.android.synthetic.main.fragment_immersive_detail.*
import kotlinx.android.synthetic.main.toolbar_default.*

/**
 * Created by chonamdoo on 2017. 9. 19..
 */

class GalleryDetailFragment : BaseFragment(){
    private lateinit var activity : GalleryDetailActivity
    override fun getLayoutResource(): Int = R.layout.fragment_immersive_detail
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img_path = arguments.getString("img_path")
        img_path?.let {
            img_photo.loadImg(img_path)
        }
        LollipopCompatSingleton.fitStatusBarTranslucentPadding(toolbar, activity)

        toolbar?.let {
            toolbarTitle.text = getString(R.string.app_name)
            activity.setSupportActionBar(it)
            activity.supportActionBar?.setDisplayShowTitleEnabled(false)
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            activity.supportActionBar?.setHomeButtonEnabled(true)
            it.setNavigationOnClickListener {
                activity.onBackPressed()
            }
        }
        val toolbarColor = ContextCompat.getColor(activity, R.color.colorPrimary)
        scrollView.setupImmersiveEffect(activity, img_photo, toolbar, toolbarColor, toolbarTitle)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as GalleryDetailActivity
    }

    companion object {
        fun INSTANCE(bundle : Bundle) : GalleryDetailFragment{
            return GalleryDetailFragment().apply {
                arguments = bundle/*Bundle().apply {
                    putString("img_path",imgPath)
                }*/
            }
        }
    }
}
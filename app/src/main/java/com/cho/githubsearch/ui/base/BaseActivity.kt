package com.cho.githubsearch.ui.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_toolbar.*
import kotlinx.android.synthetic.main.toolbar_default.*

/**
 * Created by chonamdoo on 2017. 8. 1..
 */

abstract class BaseActivity: RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)

    }

    fun setArrowToolbar(title : String =""){
        toolbar?.let {
            toolbarTitle.text = title
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

}
package com.cho.githubsearch.ui.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_toolbar.*

/**
 * Created by chonamdoo on 2017. 8. 1..
 */

abstract class BaseActivity: RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
//        setToolar()
    }

    fun setArrowToolbar(title : String =""){
        toolbar?.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.title = title
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

   /* fun setToolar(){
        toolbar?.let {
            setSupportActionBar(it)
        }
    }
    fun setArrowToolbar(){
        toolbar?.let {
            it.setNavigationIcon(R.mipmap.btn_main_back)
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
    fun setArrowToolbar(title : String){
        toolbar?.let {
            it.title = title
            it.setNavigationIcon(R.mipmap.btn_main_back)
            setSupportActionBar(it)
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }*/
}
package com.cho.githubsearch.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * Created by chonamdoo on 2017. 8. 1..
 */

abstract class BaseFragment : RxFragment(){
    @LayoutRes
    abstract fun getLayoutResource(): Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(getLayoutResource(), container, false)
}
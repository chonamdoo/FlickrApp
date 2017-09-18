package com.cho.githubsearch.ui.widget.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}
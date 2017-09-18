package com.cho.githubsearch.ui.widget.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cho.githubsearch.R
import com.cho.githubsearch.extentions.inflate
import android.support.v7.widget.StaggeredGridLayoutManager


/**
 * Created by chonamdoo on 2017. 9. 17..
 */


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        when(holder.itemView.layoutParams){
            is StaggeredGridLayoutManager.LayoutParams->{
                val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.isFullSpan = true
            }
            is GridLayoutManager.LayoutParams ->{
                val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.isFullSpan = true
            }
        }
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.loading_footer))

}
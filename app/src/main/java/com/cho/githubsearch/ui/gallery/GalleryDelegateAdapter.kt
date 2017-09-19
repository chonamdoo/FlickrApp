package com.cho.githubsearch.ui.gallery

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cho.githubsearch.R
import com.cho.githubsearch.data.model.Photo
import com.cho.githubsearch.extentions.inflate
import com.cho.githubsearch.extentions.loadImg
import com.cho.githubsearch.ui.widget.adapter.ViewType
import com.cho.githubsearch.ui.widget.adapter.ViewTypeDelegateAdapter
import kotlinx.android.synthetic.main.item_photo_view.view.*

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

class GalleryDelegateAdapter(private val onItemClick: (Photo)->Unit) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ViewHolder
        holder.onBind(item as Photo)
    }

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout
            .item_photo_view)){
        fun onBind(photo: Photo){
            itemView.run {
                setOnClickListener {
                    onItemClick(photo)
                }
                img_photo.loadImg(photo.getImageUrl())
            }
        }
    }

}
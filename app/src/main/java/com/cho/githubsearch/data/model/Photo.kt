package com.cho.githubsearch.data.model

import com.cho.githubsearch.ui.widget.adapter.AdapterConstants
import com.cho.githubsearch.ui.widget.adapter.ViewType

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

data class Photo(val id: String,
                 val owner: String,
                 val secret: String,
                 val server: String,
                 val farm: Int,
                 val title: String,
                 val ispublic: Int,
                 val isfriend: Int,
                 val isfamily: Int,
                 var isLike: Boolean):ViewType {

    override fun getViewType(): Int = AdapterConstants.ITEM
    fun getImageUrl(): String
            = "https://farm$farm.staticflickr.com/$server/${id}_${secret}_c.jpg"
}
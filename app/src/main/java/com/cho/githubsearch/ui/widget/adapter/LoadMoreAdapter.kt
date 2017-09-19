package com.cho.githubsearch.ui.widget.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.cho.githubsearch.data.model.Photo
import com.cho.githubsearch.ui.gallery.GalleryDelegateAdapter
import java.util.ArrayList

/**
 * Created by chonamdoo on 2017. 9. 18..
 */

class LoadMoreAdapter :  RecyclerView.Adapter<RecyclerView
.ViewHolder>(){
    private var items = ArrayList<ViewType>()
    var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    /*init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.ITEM, GalleryDelegateAdapter(onItemClick))
        items = ArrayList()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType).onCreateViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()
    override fun getItemCount() = items.size

    fun replaceAllItems(items: List<ViewType>) {
        this.items.clear()
        this.items.addAll(items)
        addPagination()
        notifyDataSetChanged()
    }

    fun addItems(items: List<ViewType>) {
        deletePagination()
//        items.indices
//                .map { items[it] as Photo }
//                .forEach { Log.v("DEBUG900","img : ${it.getImageUrl()}") }
        this.items.addAll(items)
        addPagination()
        notifyItemRangeInserted(this.items.size, items.size)
    }

    fun add(item: ViewType) {
        this.items.add(item)
    }

    private fun addPagination() {
        items.add(loadingItem)
    }

    private fun deletePagination() {
        if (items.size != 0) {
            items.removeAt(items.size - 1)
        }
    }
}
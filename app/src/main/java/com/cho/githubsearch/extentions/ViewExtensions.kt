package com.cho.githubsearch.extentions

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.cho.githubsearch.glide.GlideApp
import kotlinx.android.synthetic.main.item_photo_view.view.*

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE else View.GONE
    }

fun Context.inflateLayout(layoutResId: Int): View {
    return inflateView(this, layoutResId, null, false)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View {
    return inflateLayout(layoutResId, parent, true)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View {
    return inflateView(this, layoutResId, parent, attachToRoot)
}

private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    GlideApp.with(context).load(imageUrl).optionalCenterInside().into(this)
}




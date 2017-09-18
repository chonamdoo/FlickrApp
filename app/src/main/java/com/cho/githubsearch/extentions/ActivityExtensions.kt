package com.cho.githubsearch.extentions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.enableToolbarBackButton() {
    delegate.supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

fun FragmentActivity.replaceFragmentToActivity(mainViewId: Int, fragment: Fragment, tag: String) {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(mainViewId, fragment, tag)
    transaction.commitAllowingStateLoss()
}
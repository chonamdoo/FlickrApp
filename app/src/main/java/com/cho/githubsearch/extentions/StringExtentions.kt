package com.cho.githubsearch.extentions

import android.widget.Toast
import com.cho.githubsearch.AppContext

/**
 * Created by chonamdoo on 2017. 8. 16..
 */

fun String.toast(length: Int = Toast.LENGTH_SHORT): Unit {
    Toast.makeText(AppContext.getInstance(), this, length).show()
}
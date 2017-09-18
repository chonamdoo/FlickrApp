package com.cho.githubsearch.data.model

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

data class Photos(val page: Int,
                  val pages: Int,
                  val perpage: Int,
                  val total: String,
                  val photo: List<Photo>,
                  val stat: String)
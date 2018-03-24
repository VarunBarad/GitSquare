package com.varunbarad.gitsquare.screens.repocontributors

import android.arch.lifecycle.ViewModel
import com.varunbarad.gitsquare.model.Contributor

/**
 * Creator: Varun Barad
 * Date: 25-03-2018
 * Project: GitSquare
 */
const val SORT_ORDER_ASC = false
const val SORT_ORDER_DESC = true

class ContributorsViewModel : ViewModel() {
  lateinit var contributors: List<Contributor>
  var sortOrderDesc = SORT_ORDER_ASC
}
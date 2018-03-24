package com.varunbarad.gitsquare.screens.repocontributors

import android.arch.lifecycle.ViewModel
import com.varunbarad.gitsquare.model.Contributor

/**
 * Creator: Varun Barad
 * Date: 25-03-2018
 * Project: GitSquare
 */
class ContributorsViewModel : ViewModel() {
  lateinit var contributors: ArrayList<Contributor>
}
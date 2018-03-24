package com.varunbarad.gitsquare.presenters

import com.varunbarad.gitsquare.views.SquareContribsView

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
interface SquareContribsPresenter {
  val view: SquareContribsView

  fun loadContributorsFromNetwork()
}
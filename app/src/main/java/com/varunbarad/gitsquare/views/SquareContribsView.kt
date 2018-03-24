package com.varunbarad.gitsquare.views

import com.varunbarad.gitsquare.model.Contributor
import com.varunbarad.gitsquare.presenters.SquareContribsPresenter

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
interface SquareContribsView {
  var presenter: SquareContribsPresenter

  fun showContributors(contributors: ArrayList<Contributor>)
  fun showError()
  fun showProgress()
}
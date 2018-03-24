package com.varunbarad.gitsquare.screens.repocontributors

import com.varunbarad.gitsquare.model.Contributor

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
interface SquareContribsPresenter {
  val view: SquareContribsView

  fun loadContributorsFromNetwork()
  fun sortContributors(contributors: List<Contributor>, sortDesc: Boolean): List<Contributor>
}

interface SquareContribsView {
  var presenter: SquareContribsPresenter

  fun showContributors(contributors: List<Contributor>)
  fun showError()
  fun showProgress()
}
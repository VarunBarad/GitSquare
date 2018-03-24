package com.varunbarad.gitsquare.screens.repocontributors

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.varunbarad.gitsquare.R
import com.varunbarad.gitsquare.databinding.ActivitySquareContribsBinding
import com.varunbarad.gitsquare.model.Contributor

class SquareContribsActivity : AppCompatActivity(), SquareContribsView {
  override lateinit var presenter: SquareContribsPresenter
  private lateinit var dataBinding: ActivitySquareContribsBinding
  private lateinit var contributorsAdapter: ContributorsAdapter
  private lateinit var contributorsViewModel: ContributorsViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_square_contribs)
    this.presenter = Presenter(this)
    this.setupActivity()
  }

  private fun setupActivity() {
    this.setSupportActionBar(dataBinding.toolbar)

    this.dataBinding
        .recyclerViewContributors.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.column_contributors), GridLayoutManager.VERTICAL, false)

    this.contributorsViewModel = ViewModelProviders.of(this).get(ContributorsViewModel::class.java)

    try {
      showContributors(contributorsViewModel.contributors)
    } catch (e: UninitializedPropertyAccessException) {
      presenter.loadContributorsFromNetwork()
    }

    this.dataBinding
        .containerOutput
        .setOnRefreshListener { presenter.loadContributorsFromNetwork() }
    this.dataBinding
        .containerError
        .setOnRefreshListener { presenter.loadContributorsFromNetwork() }
  }

  override fun showContributors(contributors: List<Contributor>) {
    contributorsViewModel.contributors = contributors

    try {
      contributorsAdapter.swapContributors(contributorsViewModel.contributors)
    } catch (e: UninitializedPropertyAccessException) {
      contributorsAdapter = ContributorsAdapter(contributorsViewModel.contributors)
      dataBinding
          .recyclerViewContributors
          .adapter = contributorsAdapter
    }

    dataBinding
        .containerError
        .isRefreshing = false
    dataBinding
        .containerError
        .visibility = View.GONE

    dataBinding
        .containerOutput
        .isRefreshing = false
    dataBinding
        .containerOutput
        .visibility = View.VISIBLE
  }

  override fun showError() {
    dataBinding
        .containerOutput
        .visibility = View.GONE
    dataBinding
        .containerOutput
        .isRefreshing = false

    dataBinding
        .containerError
        .isRefreshing = false
    dataBinding
        .containerError
        .visibility = View.VISIBLE
  }

  override fun showProgress() {
    dataBinding
        .containerError
        .visibility = View.GONE
    dataBinding
        .containerError
        .isRefreshing = false

    dataBinding
        .containerOutput
        .isRefreshing = true
    dataBinding
        .containerOutput
        .visibility = View.VISIBLE
  }

  fun toggleSortOrder(view: View) {
    contributorsViewModel.sortOrderDesc = !contributorsViewModel.sortOrderDesc
    this.showContributors(presenter.sortContributors(
        contributorsViewModel.contributors,
        contributorsViewModel.sortOrderDesc
    ))
  }
}

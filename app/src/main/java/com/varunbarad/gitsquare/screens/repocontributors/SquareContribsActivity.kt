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
  lateinit var dataBinding: ActivitySquareContribsBinding
  override lateinit var presenter: SquareContribsPresenter
  lateinit var contributorsAdapter: ContributorsAdapter
  lateinit var contributorsViewModel: ContributorsViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_square_contribs)
    this.presenter = Presenter(this)
    this.setupActivity()
  }

  private fun setupActivity() {
    this.setSupportActionBar(dataBinding.toolbar)

    this.contributorsViewModel = ViewModelProviders.of(this).get(ContributorsViewModel::class.java)

    try {
      showContributors(contributorsViewModel.contributors)
    } catch (e: UninitializedPropertyAccessException) {
      presenter.loadContributorsFromNetwork()
    }
  }

  override fun showContributors(contributors: ArrayList<Contributor>) {
    contributorsViewModel.contributors = contributors

    dataBinding
        .containerError
        .visibility = View.GONE
    dataBinding
        .containerProgress
        .visibility = View.GONE
    dataBinding
        .containerOutput
        .visibility = View.VISIBLE

    contributorsAdapter = ContributorsAdapter(contributors)
    dataBinding
        .recyclerViewContributors
        .layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.column_contributors), GridLayoutManager.VERTICAL, false)
    dataBinding
        .recyclerViewContributors
        .adapter = contributorsAdapter
  }

  override fun showError() {
    dataBinding
        .containerProgress
        .visibility = View.GONE
    dataBinding
        .containerOutput
        .visibility = View.GONE
    dataBinding
        .containerError
        .visibility = View.VISIBLE
  }

  override fun showProgress() {
    dataBinding
        .containerOutput
        .visibility = View.GONE
    dataBinding
        .containerError
        .visibility = View.GONE
    dataBinding
        .containerProgress
        .visibility = View.VISIBLE
  }
}

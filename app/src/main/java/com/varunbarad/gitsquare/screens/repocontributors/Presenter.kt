package com.varunbarad.gitsquare.screens.repocontributors

import android.util.Log
import com.varunbarad.gitsquare.model.Contributor
import com.varunbarad.gitsquare.remote.GithubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
class Presenter(override val view: SquareContribsView) : SquareContribsPresenter {
  override fun loadContributorsFromNetwork() {
    view.showProgress()
    GithubApi
        .create()
        .getRetrofitContributors()
        .enqueue(
            object : Callback<ArrayList<Contributor>> {
              override fun onResponse(call: Call<ArrayList<Contributor>>?, response: Response<ArrayList<Contributor>>?) {
                if (response != null) {
                  val contributors = response.body()
                  if (contributors != null) {
                    view.showContributors(contributors)
                  } else {
                    view.showError()
                    Log.e("GITHUB", "Response-body was null")
                  }
                } else {
                  view.showError()
                  Log.e("GITHUB", "Response was null")
                }
              }

              override fun onFailure(call: Call<ArrayList<Contributor>>?, t: Throwable?) {
                view.showError()
                Log.e("NETWORK", t?.message)
              }
            }
        )
  }
}
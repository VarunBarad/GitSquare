package com.varunbarad.gitsquare.remote

import com.varunbarad.gitsquare.model.Contributor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
interface GithubApi {
  val baseUrl: String
    get () = "https://api.github.com/"

  @GET("/repos/square/retrofit/contributors")
  fun getRetrofitContributors(): Call<ArrayList<Contributor>>

  companion object {
    fun create(): GithubApi {
      val retrofit = Retrofit.Builder()
          .baseUrl("https://api.github.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
      return retrofit.create(GithubApi::class.java)
    }
  }
}
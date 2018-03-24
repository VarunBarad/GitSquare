package com.varunbarad.gitsquare.model

import com.google.gson.annotations.SerializedName

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */

data class Contributor(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val profileUrl: String,
    @SerializedName("repos_url") val repositoriesUrl: String,
    @SerializedName("contributions") val contributions: Int
)
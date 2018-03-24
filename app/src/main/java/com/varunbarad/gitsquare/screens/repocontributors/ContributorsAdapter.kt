package com.varunbarad.gitsquare.screens.repocontributors

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.varunbarad.gitsquare.R
import com.varunbarad.gitsquare.databinding.ListItemContributorBinding
import com.varunbarad.gitsquare.model.Contributor

/**
 * Creator: Varun Barad
 * Date: 24-03-2018
 * Project: GitSquare
 */
class ContributorsAdapter(private var contributors: List<Contributor>) : RecyclerView.Adapter<ContributorsAdapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsAdapter.ViewHolder {
    val itemViewBinding: ListItemContributorBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_contributor,
        parent,
        false
    )
    return ViewHolder(itemViewBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(contributors[position])
  }

  override fun getItemCount(): Int = contributors.size

  fun swapContributors(contributors: List<Contributor>) {
    this.contributors = contributors
    this.notifyDataSetChanged()
  }

  class ViewHolder(private val itemViewBinding: ListItemContributorBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bind(contributor: Contributor) {
      itemViewBinding.contributor = contributor
      itemViewBinding.executePendingBindings()
    }
  }

}
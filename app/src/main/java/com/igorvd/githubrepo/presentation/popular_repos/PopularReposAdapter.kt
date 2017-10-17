package com.igorvd.githubrepo.presentation.popular_repos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

import android.view.LayoutInflater
import com.igorvd.githubrepo.R
import com.igorvd.githubrepo.data.model.GitHubRepo
import com.igorvd.githubrepo.utils.extensions.loadImageFromUrl
import kotlinx.android.synthetic.main.item_progress.view.*
import kotlinx.android.synthetic.main.popular_repos_item.view.*


/**
 * @author Igor Vilela
 * @since 14/10/17
 */
class PopularReposAdapter(
        val context: Context,
        val repos: List<GitHubRepo>,
        val onItemClicked: (GitHubRepo) -> Unit,
        val onRetryClick: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class MyFooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //constants for footer types
    private val TYPE_LOADING = 0
    private val TYPE_ERROR = 1
    private var currentFootType = TYPE_LOADING

    //view types
    private val ITEMS = 0
    private val LOAD_MORE = 1

    //public variables
    var hasFooter = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if(viewType == ITEMS) {
            val itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.popular_repos_item, parent, false)

            MyViewHolder(itemView)
        } else {

            val itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_progress, parent, false)

            MyFooterViewHolder(itemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == repos.size) {
            LOAD_MORE
        } else {
            ITEMS
        }
    }

    override fun getItemCount(): Int = repos.size + 1

    override fun getItemId(position: Int): Long {

        return if(position == repos.size) {

            Long.MAX_VALUE

        } else {
            repos.get(position).id.toLong()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is MyViewHolder) {
            bindItemViewHolder(holder, position)
        } else if (holder is MyFooterViewHolder) {
            bindFooterViewHolder(holder)
        }
    }

    /**
     * Shows a progress bar below the last item
     */
    fun showFooterProgress() {

        setFooterType(TYPE_LOADING)
    }

    /**
     * shows a error message below the last item
     */
    fun showFooterError() {
        setFooterType(TYPE_ERROR)
    }

    /**
     * Remove the progress or error message below the last item
     */
    fun removeFooter() {
        this.hasFooter = false
        notifyDataSetChanged()
    }

    //**************************************************************************
    // INNER METHODS
    //**************************************************************************

    /**
     * Change the footer type
     * @param[type] Must be one of [TYPE_ERROR] or [TYPE_LOADING]
     */
    private fun setFooterType(type: Int) {
        this.hasFooter = true
        this.currentFootType = type
        notifyDataSetChanged()
    }

    private fun bindItemViewHolder(holder: MyViewHolder, position: Int) {
        val repo: GitHubRepo = repos.get(position)

        holder.itemView.repoListTvTitle.text = repo.name
        holder.itemView.repoListTvDescription.text = repo.description
        holder.itemView.repoListTvForks.text = repo.forksCount.toString()
        holder.itemView.repoListTvStars.text = repo.stargazersCount.toString()
        holder.itemView.repoListTvUsername.text = repo.owner.login
        holder.itemView.repoListIvAvatar.loadImageFromUrl(repo.owner.avatarUrl)
        holder.itemView.setOnClickListener { onItemClicked.invoke(repo) }
    }

    private fun bindFooterViewHolder(holder: MyFooterViewHolder) {

        val visibility = if(hasFooter) View.VISIBLE else View.GONE
        holder.itemView.progressRoot.visibility = visibility

        if(currentFootType == TYPE_LOADING) {

            holder.itemView.itemProgressLLRetry.visibility = View.GONE
            holder.itemView.itemprogressIvRetryIcon.visibility = View.GONE
            holder.itemView.progressBar.visibility = View.VISIBLE

            holder.itemView.progressRoot.setOnClickListener {  }

        } else if (currentFootType == TYPE_ERROR) {

            holder.itemView.progressBar.visibility = View.GONE
            holder.itemView.itemProgressLLRetry.visibility = View.VISIBLE
            holder.itemView.itemprogressIvRetryIcon.visibility = View.VISIBLE

            holder.itemView.progressRoot.setOnClickListener {
                onRetryClick.invoke()
            }

        }
    }


}
package com.paulsoia.githubauth.presentation.ui.user.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.presentation.ui.base.BaseViewHolder
import com.paulsoia.githubauth.presentation.utils.inflate
import kotlinx.android.synthetic.main.list_item_repo.view.*
import javax.inject.Inject

class RepoAdapter @Inject constructor() : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private val items = mutableListOf<Repo>()

    internal fun swapData(list: List<Repo>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return RepoViewHolder(parent.inflate(R.layout.list_item_repo))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as? RepoViewHolder)?.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RepoViewHolder(view: View) : BaseViewHolder<Repo>(view) {

        override fun bind(item: Repo) {
            with(itemView) {
                tvTitle.text = item.name
                tvDesc.text = item.description
            }
        }

    }

}
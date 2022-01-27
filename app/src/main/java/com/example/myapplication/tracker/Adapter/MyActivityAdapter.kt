package com.example.myapplication.tracker.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.R
import com.example.myapplication.tracker.fragment.MyActivityDetailsFragment
import com.example.myapplication.tracker.model.ActivityModel
import com.example.myapplication.tracker.model.CardItemModel
import com.example.myapplication.tracker.model.DateLabelModel
import com.example.myapplication.tracker.viewholder.ActivityViewHolder
import com.example.myapplication.tracker.viewholder.DateLabelViewHolder
import com.example.myapplication.tracker.viewholder.ItemViewHolder

open class MyActivityAdapter(private val fragmentManager: FragmentManager) :
    ListAdapter<CardItemModel, ItemViewHolder>(CardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.my_activity_card, parent, false)
                ActivityViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.date_label, parent, false)
                DateLabelViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]::class) {
            ActivityModel::class -> 0
            DateLabelModel::class -> 1
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindValues(currentList[position])

        if (holder is ActivityViewHolder) {
            holder.itemView.setOnClickListener {
                val activeFragment = fragmentManager.fragments.firstOrNull { !it.isHidden }

                fragmentManager.beginTransaction().apply {
                    if (activeFragment != null) hide(activeFragment)

                    add(
                        R.id.fragment_view_activity,
                        MyActivityDetailsFragment.newInstance(holder.activityId),
                        MyActivityDetailsFragment.tag
                    )

                    addToBackStack(MyActivityDetailsFragment.tag)

                    commit()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
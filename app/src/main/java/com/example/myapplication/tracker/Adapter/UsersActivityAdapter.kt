package com.example.myapplication.tracker.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.example.myapplication.tracker.fragment.UsersActivityDetailsFragment
import com.example.myapplication.tracker.model.DateLabelModel
import com.example.myapplication.tracker.model.UsersActivityModel
import com.example.myapplication.tracker.viewholder.DateLabelViewHolder
import com.example.myapplication.tracker.viewholder.ItemViewHolder
import com.example.myapplication.tracker.viewholder.UserActivityViewHolder

class UsersActivityAdapter(private val fragmentManager: FragmentManager) :
    MyActivityAdapter(fragmentManager) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.users_activity_card, parent, false)
                UserActivityViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.date_label, parent, false)
                DateLabelViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindValues(currentList[position])

        if (holder is UserActivityViewHolder) {
            holder.itemView.setOnClickListener {
                val activeFragment = fragmentManager.fragments.firstOrNull { !it.isHidden }

                fragmentManager.beginTransaction().apply {
                    if (activeFragment != null) hide(activeFragment)

                    add(
                        R.id.fragment_view_activity,
                        UsersActivityDetailsFragment.newInstance(holder.activityId),
                        UsersActivityDetailsFragment.tag
                    )

                    addToBackStack(UsersActivityDetailsFragment.tag)

                    commit()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]::class) {
            UsersActivityModel::class -> 0
            DateLabelModel::class -> 1
            else -> -1
        }
    }
}
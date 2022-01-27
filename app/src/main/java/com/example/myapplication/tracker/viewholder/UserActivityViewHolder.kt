package com.example.myapplication.tracker.viewholder

import android.view.View
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.tracker.model.CardItemModel
import com.example.myapplication.tracker.model.UsersActivityModel

class UserActivityViewHolder(itemView: View) : ActivityViewHolder(itemView) {
    private var activityUserTextView: TextView? = null

    init {
        activityUserTextView = itemView.findViewById(R.id.activity_user_caption)
    }

    override fun bindValues(itemModel: CardItemModel) {
        val userActivityModel = itemModel as UsersActivityModel
        activityProgressTextView?.text = userActivityModel.activityProgress
        timeProgressTextView?.text = userActivityModel.timeProgress
        activityTypeTextView?.text = userActivityModel.activityType
        activityDateTextView?.text = userActivityModel.activityDate
        activityUserTextView?.text = userActivityModel.user
    }
}
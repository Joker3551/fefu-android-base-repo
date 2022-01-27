package com.example.myapplication.tracker.viewholder

import android.view.View
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.tracker.model.CardItemModel
import com.example.myapplication.tracker.model.DateLabelModel

class DateLabelViewHolder(itemView: View) : ItemViewHolder(itemView) {
    private var dateTextView: TextView? = null

    init {
        dateTextView = itemView.findViewById(R.id.activity_date_label)
    }

    override fun bindValues(itemModel: CardItemModel) {
        val dateModel = itemModel as DateLabelModel
        dateTextView?.text = dateModel.date
    }
}
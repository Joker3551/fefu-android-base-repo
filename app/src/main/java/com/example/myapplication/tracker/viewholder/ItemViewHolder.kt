package com.example.myapplication.tracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.tracker.model.CardItemModel

abstract class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindValues(itemModel: CardItemModel)
}
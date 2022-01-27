package com.example.myapplication.tracker.Adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.tracker.model.CardItemModel


class CardDiffCallback : DiffUtil.ItemCallback<CardItemModel>() {
    override fun areItemsTheSame(oldItem: CardItemModel, newItem: CardItemModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CardItemModel, newItem: CardItemModel): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}
package com.example.expandable_cardview_2

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_parent.view.*

class ExpandableCardViewAdapter(var items: MutableList<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val PARENT = 0
        val CHILD = 1
        val OPEN = 0.0F
        val CLOSE = 180.0F
    }

    data class Item(val type: Int = 0,
                    var text: String = "Default",
                    var children: List<Item>? = null)

    inner class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        var textView = v.item_text
        val openImageView = v.open_bottun
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
    }
}
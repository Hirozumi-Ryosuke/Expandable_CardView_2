package com.example.expandable_cardview_2

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_parent.view.*

class ExpandableCardViewAdapter(var items: MutableList<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder> (){
    companion object {
        const val PARENT = 0
        const val CHILD = 1
        const val OPEN = 0.0F
        const val CLOSE = 180.0F
    }
    private lateinit var container: LinearLayout
    private lateinit var inputMethodManager: InputMethodManager

    data class Item(val type: Int = 0,
                    var text: String = "Default",
                    var children: List<Item>? = null)

    inner class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        val toggleImageView:ImageView? = v.item_toggle_bottun
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view: View? = null

        when (viewType) {
            PARENT -> view = inflater.inflate(R.layout.cardview_parent, parent, false)
            CHILD -> view = inflater.inflate(R.layout.cardview_child, parent, false)
        }

        return this.ItemHolder(view!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnTouchListener { v, event ->
            inputMethodManager.hideSoftInputFromWindow(
                container.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
            holder.itemView.requestFocus()
            false
        }

        val itemHolder = holder as? ItemHolder
        val item = items[position]

        itemHolder?.let { it ->
            it.toggleImageView.let { it1 ->
                it1?.setImageResource(R.drawable.toggle)
                it1?.rotation = if (item.children == null) OPEN else CLOSE

                it1?.setOnClickListener { view ->
                    val start: Int = items.indexOf(item) + 1
                    if (item.children == null) {
                        var count = 0
                        var nextHeader = items.indexOf(items.find { it2 ->
                            (count++ >= start) && (it2.type == item.type)
                        })

                        if (nextHeader == -1) nextHeader = items.size
                        item.children = items.slice(start until nextHeader)

                        val end = item.children!!.size
                        if (end > 0) items.removeAll(item.children!!)

                        view.animate().rotation(CLOSE).start()
                        notifyItemRangeRemoved(start, end)
                    } else {
                        item.children?.let {
                            items.addAll(start, it)
                            view.animate().rotation(OPEN).start()
                            notifyItemRangeInserted(start, it.size)
                            item.children = null
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int): Int = items[position].type
}
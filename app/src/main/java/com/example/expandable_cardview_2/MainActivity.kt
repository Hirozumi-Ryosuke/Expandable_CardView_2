package com.example.expandable_cardview_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView= recycler_cardview
        val itemList = mutableListOf<ExpandableCardViewAdapter.Item>()

        val item = ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT)
        item.children = listOf(
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(item)

/*
        ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT)
        item.children = listOf(
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(item)
*/

        cardView.layoutManager = LinearLayoutManager(this)
        cardView.adapter = ExpandableCardViewAdapter(itemList)
    }
}



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

        /*ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT)
        item.children = listOf(
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(item)*/


        /*itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD))*/

        /*val nation = ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "Nation")
        nation.children = listOf(
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Republic Of Korea"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Canada"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "America"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Japan"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Denmark"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Britain"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "China"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Russia"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "France"),
            ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Turkey"))
        itemList.add(nation)
*/


        cardView.layoutManager = LinearLayoutManager(this)
        cardView.adapter = ExpandableCardViewAdapter(itemList)
    }
}
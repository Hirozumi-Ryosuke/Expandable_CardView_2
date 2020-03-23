package com.example.expandable_cardview_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandable_cardview_2.ExpandableCardViewAdapter.*
import kotlinx.android.synthetic.main.activity_main.*
import com.example.expandable_cardview_2.ExpandableCardViewAdapter as ExpandableCardViewAdapter1
import com.example.expandable_cardview_2.ExpandableCardViewAdapter.Item as Item1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView: RecyclerView? = recycler_cardview
        val itemList = mutableListOf<Item1>()

        val item = Item1(type = ExpandableCardViewAdapter1.PARENT, text = "Parent")
        item.children = listOf(
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_1"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_2"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_3"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_4"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_5"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_6"),
            Item1(ExpandableCardViewAdapter1.CHILD, "Child_7")
        )
        itemList.add(item)

        val nation = ExpandableCardViewAdapter1.Item(com.example.expandable_cardview_2.ExpandableCardViewAdapter.PARENT, "Nation")
        nation

        if (cardView != null) cardView.layoutManager = LinearLayoutManager(this)
        (cardView ?: return).adapter = ExpandableCardViewAdapter1(itemList)
    }


}



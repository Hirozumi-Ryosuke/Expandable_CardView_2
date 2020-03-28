package com.example.expandable_cardview_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardview_child.*
import kotlinx.android.synthetic.main.cardview_parent.*
import android.view.inputmethod.InputMethodManager as InputMethodManager1
import kotlinx.android.synthetic.main.cardview_parent.cardview_parent as cardview_parent1

class MainActivity : AppCompatActivity() {

    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        item_text_parent = findViewById(R.id.cardview_parent)
        item_text_child = findViewById(R.id.cardview_child)
        InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

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

        cardView.layoutManager = LinearLayoutManager(this)
        cardView.adapter = ExpandableCardViewAdapter(itemList)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        inputMethodManager.hideSoftInputFromWindow(cardview_parent1.windowToken, InputMethodManager1.HIDE_NOT_ALWAYS)
        cardview_parent1.requestFocus()
        cardview_child.requestFocus()
        return false
    }
}
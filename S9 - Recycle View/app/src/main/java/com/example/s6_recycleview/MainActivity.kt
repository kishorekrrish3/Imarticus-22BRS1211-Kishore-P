package com.example.s6_recycleview

import ItemAdapter
import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        val items: MutableList<Item> = ArrayList<Item>()
        items.add(Item(R.drawable.image1, false))
        items.add(Item(R.drawable.image2, false))
        items.add(Item(R.drawable.image3, false))

        val adapter = ItemAdapter(items)
        recyclerView.setAdapter(adapter)
        }
    }
}


package com.example.sabzimandi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val TAG = "Ecom"
    var mItemList: List<Item> = listOf(
        Item("Mango",1,"mango","Fresh",220,10,"10","5"),
        Item("Banana",2,"banana","BigBasket",250,20,"20","7"),
        Item("Tomato",3,"tomato","BigBasket",250,20,"20","8")
    )
    private var itemAdapter: ItemAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Setup recyclerView
        itemAdapter = ItemAdapter(mItemList, this)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
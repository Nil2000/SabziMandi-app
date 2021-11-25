package com.example.sabzimandi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    val TAG = "Ecom"

    lateinit var itemList: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList = loadJSONData()

        val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = ItemAdapter(itemList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun loadJSONData(): List<Item> {
        val jsonString = loadJSONString(this)
        val mGson = Gson()
        val sType = object : TypeToken<List<Item>>() {}.type
        return mGson.fromJson(jsonString, sType)
    }

    private fun loadJSONString(context: Context): String {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.list)
        return inputStream.bufferedReader().use { it.readText() }
    }
}
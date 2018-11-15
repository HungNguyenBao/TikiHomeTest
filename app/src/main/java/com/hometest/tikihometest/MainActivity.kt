package com.hometest.tikihometest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val myStringArray = arrayOf("xiaomi",
        "bitis hunter",
        "bts",
        "balo",
        "bitis hunter x",
        "tai nghe",
        "harry potter",
        "anker",
        "iphone",
        "balo nữ",
        "nguyễn nhật ánh",
        "đắc nhân tâm",
        "ipad",
        "senka",
        "tai nghe bluetooth",
        "son",
        "maybelline",
        "laneige",
        "kem chống nắng",
        "anh chính là thanh xuân của em")
    val keyWords : ArrayList<String> = ArrayList()
    private lateinit var listKeyWorkAdapter: ListKeyWorkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        keyWords.addAll(myStringArray)
        listKeyWorkAdapter = ListKeyWorkAdapter(keyWords, this)
        with(listKeyWork) {
            val llm = android.support.v7.widget.LinearLayoutManager(
                this@MainActivity,
                android.support.v7.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            layoutManager = llm
            adapter = listKeyWorkAdapter
        }

    }
}

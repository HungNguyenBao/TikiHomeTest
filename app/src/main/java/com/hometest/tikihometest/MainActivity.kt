package com.hometest.tikihometest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.hometest.tikihometest.models.KeyWord
import com.hometest.tikihometest.retrofit.Client
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val keyWords : ArrayList<KeyWord> = ArrayList()
    private lateinit var listKeyWordAdapter: ListKeyWordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listKeyWordAdapter = ListKeyWordAdapter(keyWords, this)
        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        Client.apiService.getKeyWords().enqueue(object : Callback<ArrayList<String>> {
            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                Log.e(TAG, t.message)
            }

            override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                if (response.isSuccessful) {
                    for (k in response.body()?:ArrayList()) {
                        keyWords.add(KeyWord(k))
                    }
                    updateUI()
                }
            }

        })
    }

    private fun updateUI() {
        progress.visibility = View.GONE
        with(listKeyWord) {
            val llm = android.support.v7.widget.LinearLayoutManager(
                this@MainActivity,
                android.support.v7.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            layoutManager = llm
            adapter = listKeyWordAdapter
        }
    }
}

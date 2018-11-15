package com.hometest.tikihometest

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.hometest.tikihometest.models.KeyWord
import kotlinx.android.synthetic.main.key_word_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class ListKeyWordAdapter(private val keyWords: ArrayList<KeyWord>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.key_word_item, p0, false)
        return ListKeyWordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return keyWords.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val holder = p0 as ListKeyWordViewHolder
        val item = keyWords[p1]
        val layoutParams = holder.itemContainer.layoutParams as RecyclerView.LayoutParams
        if (p1 == itemCount - 1) {
            layoutParams.marginEnd = pxFromDp(context, 8f).toInt()
        } else {
            layoutParams.marginEnd = 0
        }
        holder.itemContainer.setBackgroundResource(R.drawable.rounded_corners)
        val drawable = holder.itemContainer.background
        drawable.setColorFilter(item.color, PorterDuff.Mode.SRC)
        holder.keyWord.text = item.keyWord
    }

    inner class ListKeyWordViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val itemContainer: FrameLayout = mView.itemContainer
        val keyWord: TextView = mView.keyWord
    }

    private fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }
}
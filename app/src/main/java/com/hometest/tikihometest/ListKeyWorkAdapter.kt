package com.hometest.tikihometest

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.key_word_item.view.*
import java.util.*

class ListKeyWorkAdapter(private val keyWorks: ArrayList<String>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.key_word_item, p0, false)
        return ListKeyWorkViewHolder(view)
    }

    override fun getItemCount(): Int {
        return keyWorks.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val holder = p0 as ListKeyWorkViewHolder
        val item = keyWorks[p1]
        val layoutParams = holder.itemContainer.layoutParams as RecyclerView.LayoutParams
        if (p1 == itemCount - 1) {
            layoutParams.marginEnd = pxFromDp(context, 8f).toInt()
        } else {
            layoutParams.marginEnd = 0
        }
        holder.itemContainer.setBackgroundResource(R.drawable.rounded_corners)
        val drawable = holder.itemContainer.background
        val color = getRandColor()
        drawable.setColorFilter(color, PorterDuff.Mode.SRC)
        holder.keyWork.text = item
    }

    inner class ListKeyWorkViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val itemContainer: FrameLayout = mView.itemContainer
        val keyWork: TextView = mView.keyWord
    }

    private fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    private fun getRandColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(150), rnd.nextInt(150), rnd.nextInt(150))
    }
}
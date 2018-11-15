package com.hometest.tikihometest.models

import android.graphics.Color
import java.util.*

class KeyWord(keyWord: String) {
    var keyWord: String
    var color: Int

    init {
        val arrOfWord = keyWord.split(" ")
        this.keyWord = if(arrOfWord.size > 1) addEndLine(arrOfWord) else keyWord
        this.color = getRandColor()
    }

    private fun getRandColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(150), rnd.nextInt(150), rnd.nextInt(150))
    }

    private fun addEndLine(arrWord: List<String>): String {
        val arrayListWord = ArrayList(arrWord)
        val positionEndLine = arrayListWord.size / 2 - 1
        arrayListWord[positionEndLine] = "${arrayListWord[positionEndLine]}\n"
        val newItem = StringBuffer()
        for ((i, v) in arrayListWord.withIndex()) {
            val item = if (i == positionEndLine || i == arrayListWord.size - 1) v else "$v "
            newItem.append(item)
        }
        return newItem.toString()
    }
}
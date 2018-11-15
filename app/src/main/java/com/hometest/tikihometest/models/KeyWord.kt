package com.hometest.tikihometest.models

import android.graphics.Color
import java.util.*
import kotlin.collections.ArrayList

class KeyWord(keyWord: String) {
    var keyWord: String
    var color: Int

    init {
        this.keyWord = addEndLine(keyWord)
        this.color = getRandColor()
    }

    private fun getRandColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(150), rnd.nextInt(150), rnd.nextInt(150))
    }

    private fun addEndLine(keyWord: String): String {
        val arrOfWord = keyWord.split(" ")
        if (arrOfWord.size == 1) return keyWord
        val arrayListWord = ArrayList(arrOfWord)
        var positionEndLine = arrayListWord.size / 2 - 1
        if (isMoveEndLine(arrayListWord, positionEndLine)) positionEndLine++
        arrayListWord[positionEndLine] = "${arrayListWord[positionEndLine]}\n"
        val newWord = StringBuffer()
        for ((i, v) in arrayListWord.withIndex()) {
            val item = if (i == positionEndLine || i == arrayListWord.size - 1) v else "$v "
            newWord.append(item)
        }
        return newWord.toString()
    }

    private fun isMoveEndLine(arrayListWord: ArrayList<String>, positionEndLine: Int) :Boolean {
        if (arrayListWord.size == 2) return false
        var lengthLeft = 0
        var lengthRight = 0
        for (i in 0..positionEndLine) {
            lengthLeft += arrayListWord[i].length
        }
        for (j in positionEndLine + 1 until arrayListWord.size) {
            lengthRight += arrayListWord[j].length
        }
        return lengthLeft * 2 < lengthRight
    }
}
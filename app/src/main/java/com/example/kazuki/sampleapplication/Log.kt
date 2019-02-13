package com.example.kazuki.sampleapplication

import android.util.Log
import java.util.regex.Pattern

object Log {

    fun v(msg: String) {
        Log.d(getTag(), msg)
    }

    fun w(msg: String) {
        Log.d(getTag(), msg)
    }

    fun e(msg: String) {
        Log.d(getTag(), msg)
    }

    private fun getTag(): String {
        val stackTraceElement = Thread.currentThread().stackTrace[4]
        val className = stackTraceElement.className
        val pattern = Pattern.compile("[\\.]+")
        val splitedStrings = pattern.split(className)
        val simpleClass = splitedStrings[splitedStrings.size - 1]

        val methodName = stackTraceElement.methodName
        val lineNumber = stackTraceElement.lineNumber

        return "$simpleClass#$methodName:$lineNumber"
    }
}

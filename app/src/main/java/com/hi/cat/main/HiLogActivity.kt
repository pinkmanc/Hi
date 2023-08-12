package com.hi.cat.main

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hi.cat.R
import com.hi.library.hilog.HiLog

/**
@author JessPinkman
@date   2023-08-11/14:08
 **/
class HiLogActivity:AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hilog)
    findViewById<View>(R.id.btn_log).setOnClickListener {
      printLog()
    }
  }
  private fun printLog() {
    HiLog.a("suafhigsdfyuskgeadvfyuedasgv")
  }
}
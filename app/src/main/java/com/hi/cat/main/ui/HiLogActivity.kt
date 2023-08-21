package com.hi.cat.main.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hi.cat.R
import com.hi.library.hilog.HiLog
import com.hi.library.hilog.HiLogManager
import com.hi.library.hilog.HiViewPrinter

/**
@author JessPinkman
@date   2023-08-11/14:08
 **/
class HiLogActivity:AppCompatActivity() {
  var viewPrinter : HiViewPrinter? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hi_log)
    viewPrinter = HiViewPrinter(this)
    findViewById<View>(R.id.btn_log).setOnClickListener {
      printLog()
    }
    viewPrinter!!.viewProvider.showFloatingView()
    HiLogManager.getInstance().addPrinter(viewPrinter)
  }
  private fun printLog() {

    HiLog.e("5566")
  }
}
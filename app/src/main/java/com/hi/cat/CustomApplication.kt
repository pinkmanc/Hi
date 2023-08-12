package com.hi.cat

import android.app.Application
import com.google.gson.Gson
import com.hi.library.hilog.HiConsolePrinter
import com.hi.library.hilog.HiLogConfig
import com.hi.library.hilog.HiLogManager
import com.hi.library.hilog.HiLogPrinter
import com.hi.library.hilog.JsonParser

/**
@author JessPinkman
@date   2023-08-11/14:03
 **/
class CustomApplication:Application() {
  override fun onCreate() {
    super.onCreate()
    HiLogManager.init(object :HiLogConfig(){
      override fun enable(): Boolean {
        return true;
      }

      override fun addStackTraceInfo(): Boolean {
        return true;
      }

      override fun addThreadInfo(): Boolean {
        return true;
      }

      override fun getStackTraceDepth(): Int {
        return 10;
      }

      override fun injectJsonParser(): JsonParser {
        return JsonParser{src ->Gson().toJson(src) }
      }

    },HiConsolePrinter())
  }
}
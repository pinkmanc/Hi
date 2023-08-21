package com.hi.cat.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.cat.R
import com.hi.hi_ui.tab.bottom.HiTabBottom
import com.hi.hi_ui.tab.bottom.HiTabBottomInfo

/**
  @author JessPinkman
  @date   2023-08-19/11:32
 **/
class HiRefreshActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hi_refresh)
    val homeInfo=HiTabBottomInfo(
      "首页",
      "fonts/iconfont.ttf",
      getString(R.string.if_home),
      null,
      "#ff656667",
      "#ffd44949"
    )

    val hiTabBottom = findViewById<HiTabBottom>(R.id.htb_home)
    hiTabBottom.setHiTabInfo(homeInfo)


  }
}
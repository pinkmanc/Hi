package com.hi.cat.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hi.cat.R
import com.hi.cat.main.ui.HiLogActivity
import com.hi.cat.main.ui.HiRefreshActivity
import com.hi.library.hilog.HiLog

/**
@author JessPinkman
@date   2023-08-11/14:06
 **/
class MainActivity:AppCompatActivity(),View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
  override fun onClick(v: View?) {
    when(v?.id){
      R.id.tv_hi_log->{
        startActivity(Intent(this, HiLogActivity::class.java))
      }
      R.id.tv_hi_refresh->{

          startActivity(Intent(this,HiRefreshActivity::class.java))
      }
    }
  }
}
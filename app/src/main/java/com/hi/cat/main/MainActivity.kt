package com.hi.cat.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hi.cat.R

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
      R.id.tv_hilog->{
        startActivity(Intent(this,HiLogActivity::class.java))
      }
    }
  }
}
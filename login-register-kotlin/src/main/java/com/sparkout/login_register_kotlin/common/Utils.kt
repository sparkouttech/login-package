package com.sparkout.login_register_kotlin.common

import android.content.Context
import android.view.View
import android.widget.Toast

class Utils {
    companion object{
        fun showToast(context: Context,message:String){
            Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
        }

        fun preventDoubleClick(view:View){
            view.isEnabled = false
            view.postDelayed({ view.isEnabled = true }, 1000)
        }
    }
}
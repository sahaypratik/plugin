package com.example.pluginapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.example.downloadmanager.pattern.CustomSnackBar
import com.example.pluginapp.R
import com.example.pluginapp.pattern.CustomToast
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_activty)

    }


    fun showCustomSnackBar(text:String,view:View,duration:Int,bgTint:Int,textColor:Int)
    {
        var builder= CustomSnackBar.Builder(text,view,duration)
        if(bgTint!=null)
        builder.setBackgroundTint(bgTint)

        if(textColor!=null)
            builder.setTextColor(textColor)


        var uih=builder.build()
        uih.show()
    }

    fun showCustomToast(text:String,context:Context,duration:Int,bottomMargin:Int,topMargin:Int,gravity:Int)
    {
        var builder= CustomToast.Builder(text,context,duration)

        /*var bottomMargin:Int= 0
        var topMargin:Int= 0
        var gravity:Int= Gravity.TOP*/
        if(bottomMargin!=null)
            builder.setBottomMargin(bottomMargin)

        if(topMargin!=null)
            builder.setTopMargin(topMargin)

        if(gravity!=null)
            builder.setGravity(gravity)

        var uih=builder.build()
        uih.show()
    }
}
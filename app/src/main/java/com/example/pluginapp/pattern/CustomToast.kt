package com.example.pluginapp.pattern

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast

class CustomToast(builder: Builder) {

    private val context: Context= builder.context
    private val text: String = builder.text
    private val duration: Int = builder.duration

    class Builder(text: String, context: Context, duration:Int){
        var text: String = text
        var context: Context =context
        var duration: Int = duration
        var bottomMargin:Int= 0
        var topMargin:Int= 0
        var gravity:Int= Gravity.TOP


        fun setToastText(text: String): Builder {
            this.text = text
            return this
        }
        fun setToastContext(view: View): Builder {
            this.context = context
            return this
        }
        fun setToastDuration(duration: Int): Builder {
            this.duration = duration
            return this
        }

        fun setBottomMargin(bottomMargin: Int): Builder {
            this.bottomMargin = bottomMargin
            return this
        }

        fun setTopMargin(topMargin: Int): Builder {
            this.topMargin = topMargin
            return this
        }

        fun setGravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }


        fun build(): Toast {
           // return Snackbar.make(view,text,duration).setTextColor(textColor).setBackgroundTint(backgroundTint)
            var toast= Toast.makeText(context,text,duration)
            toast.setGravity(Gravity.TOP,6000,6000)

            return toast

            }
        }

        /*fun buildWithAdOns(snackbar: Snackbar,textColor:Int=Color.parseColor("#3fc380"),backgroundTint:Int=Color.parseColor("#f7ca18")):Snackbar
        {
            return snackbar.
        }*/



}
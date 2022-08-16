package com.example.downloadmanager.pattern

import android.content.Context
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

class CustomSnackBar(builder: Builder)
{
    private val view: View = builder.view
    private val text: String = builder.text
    private val duration: Int = builder.duration
   // private val screenSize: String = builder.screenSize

    class Builder(text: String,view:View,duration:Int){
        var text: String = text
        var view: View =view
        var duration: Int = duration
        var textColor:Int=Color.parseColor("#3fc380")
        var backgroundTint:Int=Color.parseColor("#f7ca18")

        fun setSnackText(text: String): Builder{
            this.text = text
            return this
        }
        fun setSnackContext(view: View): Builder{
            this.view = view
            return this
        }
        fun setSnackDuration(duration: Int): Builder{
            this.duration = duration
            return this
        }

       public fun setTextColor(textColor: Int): Builder{
            this.textColor = textColor
            return this
        }

        fun setBackgroundTint(backgroundTint: Int): Builder{
            this.backgroundTint = backgroundTint
            return this
        }


        fun build(): Snackbar{
            Snackbar.LENGTH_LONG
            return Snackbar.make(view,text,duration).setTextColor(textColor).setBackgroundTint(backgroundTint)
        }

        /*fun buildWithAdOns(snackbar: Snackbar,textColor:Int=Color.parseColor("#3fc380"),backgroundTint:Int=Color.parseColor("#f7ca18")):Snackbar
        {
            return snackbar.
        }*/

    }
}

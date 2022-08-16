package com.example.pluginapp.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pluginapp.R
import com.example.pluginapp.model.RespSelector
import com.example.pluginapp.model.RespUiData
import com.example.pluginapp.retrofit.ApiUtils
import com.example.pluginapp.retrofit.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection


class MainActivity : BaseActivity() {

    var layout: LinearLayout?=null
    var userService: UserService? = ApiUtils.getUserService()
    var parentViewStack=ArrayList<ViewGroup>()
    var sc1="https://run.mocky.io/v3/ca5bf70e-b6d7-4d61-a02f-a28e6993e19b"
    var sc2="https://run.mocky.io/v3/a06a7742-5ffc-4b16-8a1d-baff0ea615f7"
    var sc3="https://run.mocky.io/v3/b0e4ad60-77d7-47ca-b182-8613458ac85e"
    var refresh:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout=findViewById(R.id.container)
        refresh=findViewById(R.id.refresh)
        parentViewStack.add(layout!!)

        setListener()




        fetchSelector()

        //layout.orientation=LinearLayout.HORIZONTAL
      /*  parentViewStack.add(layout!!)

        var textView= TextView(this)
        textView.text = "Pratik Sahay"
        textView.textSize=25f
        textView.setTextColor(Color.parseColor("#a0081b"))
        textView.gravity= Gravity.CENTER_HORIZONTAL
        layout!!.addView(textView)

        var imageView=ImageView(this)

        val vp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            200,
            200
        )
        vp.gravity=Gravity.CENTER_HORIZONTAL
        vp.topMargin=50
        imageView.layoutParams = vp
        imageView.setImageResource(R.drawable.ic_launcher_background)
        layout!!.addView(imageView)


        var button1=Button(this)
        button1.text="Login"
        button1.setBackgroundColor(Color.parseColor("#a0081b"))
        val buttonLayout1: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        buttonLayout1.gravity=Gravity.CENTER_HORIZONTAL
        buttonLayout1.topMargin=50
        button1.layoutParams = buttonLayout1
        layout!!.addView(button1)


        var button2=Button(this)
        button2.text="Register"
        button2.setBackgroundColor(Color.parseColor("#a0081b"))
        val buttonLayout2: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        buttonLayout2.gravity=Gravity.CENTER_HORIZONTAL
        buttonLayout2.topMargin=50
        button2.layoutParams = buttonLayout2
        layout!!.addView(button2)*/

    }

    fun setListener()
    {
        refresh!!.setOnClickListener {
            layout!!.removeAllViews()
            parentViewStack.clear()
            parentViewStack.add(layout!!)
            layout!!.addView(refresh)
            Toast.makeText(this,"Changing selection",Toast.LENGTH_SHORT).show()
            fetchSelector()
        }
    }
    //var imgParams=imageView.layoutParams as ViewGroup.MarginLayoutParams
    //imgParams.setMargins(0,50,0,50)
    // imageView.layoutParams=imgParams
    /*val vp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )*/

    fun fetchSelector()
    {

        var call: Call<List<RespSelector>>
        //call= userService!!.fetchUiData("UI")
        call= userService!!.fetchSelector("https://v1.nocodeapi.com/sahaypratik/supabase/DmXBArQLPNHWJIae?tableName=Selector\n")
        call.enqueue(object : Callback<List<RespSelector>> {
            override fun onFailure(call: Call<List<RespSelector>>, t: Throwable) {
                if (t.localizedMessage == "Unable to resolve host \"dev.winuall.com\": No address associated with hostname") {
                    Toast.makeText(
                        this@MainActivity,
                        "You Internet connection seems \n weak or poor!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@MainActivity, "Invalid Request", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call<List<RespSelector>>, response: Response<List<RespSelector>>) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    var body=response.body()

                    when(body!![0].scenario!!)
                    {
                        "sc1"->fetchOrgFromPkg(sc1)
                        "sc2"->fetchOrgFromPkg(sc2)
                        "sc3"->fetchOrgFromPkg(sc3)

                    }
                    Toast.makeText(this@MainActivity,"Inflating Layout of="+body!![0].scenario!!,Toast.LENGTH_SHORT).show()



                    // Toast.makeText(this@MainActivity,"wefuihbh", Toast.LENGTH_SHORT).show()
                    //inflateTextView(response.body()[0].text?:"Sample")


                }
            }
        })
    }


    fun fetchOrgFromPkg(sc:String)
    {

        var call: Call<List<RespUiData>>
        //call= userService!!.fetchUiData("UI")
        call= userService!!.fetchUiData(sc)
        call.enqueue(object : Callback<List<RespUiData>> {
            override fun onFailure(call: Call<List<RespUiData>>, t: Throwable) {
                if (t.localizedMessage == "Unable to resolve host \"dev.winuall.com\": No address associated with hostname") {
                    Toast.makeText(
                        this@MainActivity,
                        "You Internet connection seems \n weak or poor!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@MainActivity, "Invalid Request", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call<List<RespUiData>>, response: Response<List<RespUiData>>) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    var body=response.body()
                   // Toast.makeText(this@MainActivity,"wefuihbh", Toast.LENGTH_SHORT).show()
                    inflateLayout(body!!)
                    //inflateTextView(response.body()[0].text?:"Sample")


                }
            }
        })
    }


    fun inflateLayout(list:List<RespUiData>)
    {
        for(i in 0 until list!!.size)
        {
            when(list[i].type)
            {
                "TextView"->{
                   inflateTextView(list[i].text?:"Sample", list[i].text_size?:15f,list[i].text_color?:"FF6200EE",list[i].gravity?:1)
                }
                "ImageView"->{
                    inflateImageView(list[i].width?:200,list[i].height?:200,list[i].gravity?:1,list[i].marginTop?:1,list[i].marginBottom?:1,list[i].marginLeft?:1,list[i].marginRight?:1,"https://raw.githubusercontent.com/Oclemy/SampleJSON/master/spacecrafts/voyager.jpg")
                }
                "Button"->{
                    inflateButton(list[i].text?:"Sample",list[i].bg_color?:"#FF6200EE",list[i].width?:200,list[i].height?:200,list[i].gravity?:1,list[i].marginTop?:1,list[i].marginBottom?:1,list[i].marginLeft?:1,list[i].marginRight?:1)
                }
                "LinearLayout"->{
                    var layout=inflateLinearLayout(list[i].width?:200,list[i].height?:200,list[i].orientation?:1)
                    if (list[i].child!!.isNotEmpty())
                    {
                        parentViewStack.add(layout)
                        inflateLayout(list[i].child)
                    }
                }
            }
            Log.i("position",i.toString())
            if (i==list.size-1)
            {
                parentViewStack.removeAt(parentViewStack.size-1)
            }
        }
    }

    fun inflateTextView(text:String="Sample", textSize:Float=15f,textColor:String="#FF6200EE",gravity:Int=1)
    {
        var textView= TextView(this)
        textView.text = text
        textView.textSize=textSize
        textView.setTextColor(Color.parseColor(textColor))
        textView.gravity= gravity
        parentViewStack[parentViewStack.size-1]!!.addView(textView)
    }

    fun inflateImageView(width:Int=200,height:Int=200,gravity:Int=1,marginTop:Int=1,marginBottom:Int=1,marginLeft:Int=1,marginRight:Int=1,uri:String)
    {
        var imageView=ImageView(this)

        val vp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            width,
            height
        )
        vp.gravity=gravity
        vp.topMargin=marginTop
        vp.bottomMargin=marginBottom
        vp.leftMargin=marginLeft
        vp.rightMargin=marginRight
        imageView.layoutParams = vp
        Glide.with(this).load(uri).into(imageView)
        //imageView.setImageResource(R.drawable.ic_launcher_background)
        parentViewStack[parentViewStack.size-1]!!.addView(imageView)
    }

    fun inflateLinearLayout(width:Int=200,height:Int=200,orientation:Int=1):ViewGroup
    {
        val linearLayout = LinearLayout(this)
        val linearParams = LinearLayout.LayoutParams(
            width,
            height
        )
        when(orientation)
        {
            0->linearLayout.orientation = LinearLayout.HORIZONTAL
            1->linearLayout.orientation = LinearLayout.VERTICAL

        }
        linearLayout.layoutParams = linearParams
        parentViewStack[parentViewStack.size-1]!!.addView(linearLayout)
        return linearLayout

    }

    fun inflateButton(text:String="Sample",color:String="#FF6200EE",width:Int=200,height:Int=200,gravity:Int=1,marginTop:Int=1,marginBottom:Int=1,marginLeft:Int=1,marginRight:Int=1)
    {
        var button=Button(this)
        button.text=text
        button.setBackgroundColor(Color.parseColor(color))
        val buttonLayout: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            width,
            height
        )
        buttonLayout.gravity=gravity
        buttonLayout.topMargin=marginTop
        buttonLayout.bottomMargin=marginBottom
        buttonLayout.leftMargin=marginLeft
        buttonLayout.rightMargin=marginRight
        button.layoutParams = buttonLayout
        parentViewStack[parentViewStack.size-1]!!.addView(button)
    }
}
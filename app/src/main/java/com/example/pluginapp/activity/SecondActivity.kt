package com.example.pluginapp.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.pluginapp.R
import com.example.pluginapp.model.RespDialogData
import com.example.pluginapp.model.RespSelector
import com.example.pluginapp.model.RespUiData
import com.example.pluginapp.retrofit.ApiUtils
import com.example.pluginapp.retrofit.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class SecondActivity : BaseActivity() {

    var userService: UserService? = ApiUtils.getUserService()
    var sc="https://v1.nocodeapi.com/sahaypratik/supabase/rPPzxbfYBhCtSfQe?tableName=Dialog"
    var pos=1
    var layout: RelativeLayout?=null
    var refresh: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        layout=findViewById(R.id.second)
        refresh=findViewById(R.id.refreshData)

        refresh!!.setOnClickListener {
            Toast.makeText(this,"Changing selection",Toast.LENGTH_SHORT).show()
            fetchSelector()
        }
        fetchSelector()
    }


    fun fetchSelector()
    {

        var call: Call<List<RespSelector>>
        //call= userService!!.fetchUiData("UI")
        call= userService!!.fetchSelector("https://v1.nocodeapi.com/sahaypratik/supabase/DmXBArQLPNHWJIae?tableName=Selector\n")
        call.enqueue(object : Callback<List<RespSelector>> {
            override fun onFailure(call: Call<List<RespSelector>>, t: Throwable) {
                if (t.localizedMessage == "Unable to resolve host \"dev.winuall.com\": No address associated with hostname") {
                    Toast.makeText(
                        this@SecondActivity,
                        "You Internet connection seems \n weak or poor!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@SecondActivity, "Invalid Request", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call<List<RespSelector>>, response: Response<List<RespSelector>>) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    var body=response.body()

                    pos= body!![0].postion!!
                    Toast.makeText(this@SecondActivity,"Inflating Layout",Toast.LENGTH_SHORT).show()
                    fetchOrgFromPkg()
                    // Toast.makeText(this@MainActivity,"wefuihbh", Toast.LENGTH_SHORT).show()
                    //inflateTextView(response.body()[0].text?:"Sample")


                }
            }
        })
    }


    fun fetchOrgFromPkg()
    {

        var call: Call<List<RespDialogData>>
        //call= userService!!.fetchUiData("UI")
        call= userService!!.fetchDialogData(sc)
        call.enqueue(object : Callback<List<RespDialogData>> {
            override fun onFailure(call: Call<List<RespDialogData>>, t: Throwable) {
                if (t.localizedMessage == "Unable to resolve host \"dev.winuall.com\": No address associated with hostname") {
                    Toast.makeText(
                        this@SecondActivity,
                        "You Internet connection seems \n weak or poor!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@SecondActivity, "Invalid Request", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call<List<RespDialogData>>, response: Response<List<RespDialogData>>) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    var body=response.body()
                    when(pos)
                    {
                        1->{
                            for (i in 0 until body!!.size)
                            {
                                inflateUi(body[i])
                            }
                        }
                        2->{
                            inflateUi(body!![0])
                        }
                        3->{
                            inflateUi(body!![1])
                        }
                    }

                    //inflateTextView(response.body()[0].text?:"Sample")


                }
            }
        })
    }

    fun inflateUi(resp:RespDialogData)
    {
        when(resp.type)
        {
            "snackBar"->{
                showCustomSnackBar(resp.text!!, layout!!, resp.duration!!,Color.parseColor(resp.backgroundColor),Color.parseColor(resp.textColor))
            }
            "toast"->{
                showCustomToast(resp.text!!,this,resp.duration!!,resp.bottomMargin!!,resp.topMargin!!,
                    resp.gravity!!
                )
            }
        }
    }




}
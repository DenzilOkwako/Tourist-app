package com.sheldon.touristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //find al the ids

        val user=findViewById<EditText>(R.id.user)
        val email= findViewById<EditText>(R.id.email)


        val pay = findViewById<Button>(R.id.pay)



        val progressbar =findViewById<ProgressBar>(R.id.progressbar)
        progressbar.visibility = View.GONE


        //providing listener to the button
        pay.setOnClickListener {
            progressbar.visibility = View.VISIBLE

            //loopj - used to get data or get data to the net(phone ,cost)
            val client = AsyncHttpClient(true,80,443)
            val json = JSONObject() // used to convert string to json (format of data on internet)

            json.put("email", user.text.toString())
            json.put("password", email.text.toString())

            val con_body  = StringEntity(json.toString())

            client.post(this,"https://Denzil1.pythonanywhere.com/login",con_body,"application/json",
                object : JsonHttpResponseHandler(){
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        response: JSONObject?
                    ) {
                        Toast.makeText(applicationContext,"Login Successfuly"+ statusCode, Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext,BookActivity::class.java)
                        startActivity(intent)

                        progressbar.visibility = View.GONE

                    }

                    override fun onFailure(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        throwable: Throwable?,
                        errorResponse: JSONObject?
                    ) {
                        Toast.makeText(applicationContext,"Not Paid Successfuly" , Toast.LENGTH_LONG).show()
                        progressbar.visibility = View.GONE
                    }

                }//end json handler

            )//end client


        }//end listener


    }
}
package com.sheldon.touristapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val progressbar =findViewById<ProgressBar>(R.id.progressbar)
        progressbar.visibility = View.GONE


        val phone = findViewById<EditText>(R.id.phone)
        val amount = findViewById<EditText>(R.id.amount)

        val pay = findViewById<Button>(R.id.send)

        //providing listener to the button
        pay.setOnClickListener {
            progressbar.visibility = View.VISIBLE

            //loopj - used to get data or get data to the net(phone ,cost)
            val client = AsyncHttpClient(true,80,443)
            val json = JSONObject() // used to convert string to json (format of data on internet)

            json.put("phone", phone.text.toString())
            json.put("amount",amount.text.toString())

            // StringEntity - used to combine phone and cost together

            val con_body  = StringEntity(json.toString())
            client.post(this,"https://modcom.pythonanywhere.com/mpesa_payment",con_body,"application/json",
                object : JsonHttpResponseHandler(){
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        response: JSONObject?
                    ) {
                        Toast.makeText(applicationContext,"Paid Successfuly"+ statusCode, Toast.LENGTH_LONG).show()
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
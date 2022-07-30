package com.sheldon.touristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //find all the ids
        val user=findViewById<EditText>(R.id.user)
        val email= findViewById<EditText>(R.id.email)
        val password= findViewById<EditText>(R.id.password)
        val confirm= findViewById<EditText>(R.id.cornfirm)
        val progressbar =findViewById<ProgressBar>(R.id.progressbar)

        progressbar.visibility=View.GONE


        val login = findViewById<TextView>(R.id.register)
        login.setOnClickListener {
            val client = AsyncHttpClient(true,80,443)
            val json = JSONObject()
            progressbar.visibility=View.VISIBLE

            json.put("user",user.text.toString())
            json.put("email",email.text.toString())
            json.put("password",password.text.toString())
            json.put("confirm",confirm.text.toString())

            val entity =  StringEntity(json.toString())


            client.post(this,"https://denzil1.pythonanywhere.com/register",entity,"application/json",

                object : JsonHttpResponseHandler(){

                    override fun onSuccess(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        response: JSONObject?
                    ) {

                        Toast.makeText(applicationContext,"Registered successfuly"+ statusCode,Toast.LENGTH_LONG).show()
                        progressbar.visibility = View.GONE
                        val index = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(index)
                    }

                    override fun onFailure(
                        statusCode: Int,
                        headers: Array<out Header>?,
                        throwable: Throwable?,
                        errorResponse: JSONObject?
                    ) {
                        Toast.makeText(applicationContext,"Not registered"+statusCode, Toast.LENGTH_LONG).show()
                        progressbar.visibility=View.GONE
                    }

                }

                )

            val index = Intent(applicationContext, LoginActivity::class.java)
            startActivity(index)

        }

        //create a table in pythonanywhere database and insert some records
        //

    }
}
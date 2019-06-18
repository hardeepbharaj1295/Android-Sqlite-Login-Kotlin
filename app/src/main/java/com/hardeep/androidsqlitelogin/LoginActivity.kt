package com.hardeep.androidsqlitelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.hardeep.kotlinandroidinsertion.database.DatabaseQueries

class LoginActivity : AppCompatActivity() {

    lateinit var email:EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

    }

    fun login(v:View)
    {
        val db = DatabaseQueries(this)
        val res = db.loginUser(email.text.toString(),password.text.toString())
        if (res.moveToFirst())
        {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("Login Successfully")
                .setPositiveButton("ok",null)
                .show()
        }
        else
        {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert!")
                .setMessage("Login not Successfully\n Please try again")
                .setPositiveButton("ok",null)
                .show()
        }
    }

    fun register(v:View)
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

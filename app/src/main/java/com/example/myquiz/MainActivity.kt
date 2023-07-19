package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btnstart)
        val uname: TextView = findViewById(R.id.uname)
        btn.setOnClickListener {
            if ((uname.text).isEmpty()) {
                Toast.makeText(this, "username is empty", Toast.LENGTH_SHORT).show()


            } else {
                val intnt = Intent(this, QuizQuestionsActivity::class.java)
                intnt.putExtra(Constants.USER_NAME,uname.text.toString())
                startActivity(intnt)
                finish()
            }
        }

    }
}

package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val USN: TextView=findViewById(R.id.usern)
        val tvscore: TextView=findViewById(R.id.tv_score)
        val appre: TextView=findViewById(R.id.appre)

        val qfinish: Button=findViewById(R.id.btnfinish)


        USN.text=intent.getStringExtra(Constants.USER_NAME)

        val total = intent.getIntExtra(Constants.total_ques,0)
        val cans = intent.getIntExtra(Constants.CORRECT_ANS,0)

        tvscore.text="Your score is $cans out of $total"
        if (cans>9)
        {
            appre.text="Well Done"
        }else if (cans<9 && cans>5) {
            appre.text = "Can do better"
        }
        else {
            appre.text="Oops,Try Again"
        }

            qfinish.setOnClickListener{
                startActivity(Intent(this,MainActivity::class.java))
            }
        }


    }
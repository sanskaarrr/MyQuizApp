package com.example.myquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mcrtpos: Int=1
    private var mquesList:ArrayList<Questions>?=null
    private var mselectedpos: Int = 0
    private var musername: String?=null
    private var mcorrectans: Int=0



    private var progressBar: ProgressBar?=null
    private var tvprogress: TextView?=null
    private var tvques: TextView?=null
    private var tvimage: ImageView?=null

    private var tvop1: TextView?=null
    private var tvop2: TextView?=null
    private var tvop3: TextView?=null
    private var tvop4: TextView?=null
    private var btn_submit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.tv_progbar)
        tvques = findViewById(R.id.tv_ques)
        tvimage = findViewById(R.id.flag)
        tvprogress = findViewById(R.id.tv_prog)


        tvop1 = findViewById(R.id.op1)
        tvop2 = findViewById(R.id.op2)
        tvop3 = findViewById(R.id.op3)
        tvop4 = findViewById(R.id.op4)
        btn_submit= findViewById(R.id.btn_submit)


        tvop1?.setOnClickListener(this)
        tvop2?.setOnClickListener(this)
        tvop3?.setOnClickListener(this)
        tvop4?.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)

        mquesList = Constants.getQuestions()
        setQues()


        musername=intent.getStringExtra(Constants.USER_NAME)



    }

    @SuppressLint("SetTextI18n")
    private fun setQues() {
        defaultOpt()

        val ques: Questions = mquesList!![mcrtpos - 1]
        progressBar?.progress = mcrtpos
        tvprogress?.text = "$mcrtpos/${"12"}"
        tvques?.text = ques.ques

        tvop1?.text = ques.op1
        tvop2?.text = ques.op2
        tvop3?.text = ques.op3
        tvop4?.text = ques.op4
        tvimage?.setImageResource(ques.img)

        if (mcrtpos==mquesList!!.size)
            btn_submit?.text = "Finish"
        else
            btn_submit?.text = "SUBMIT"
    }
    private fun defaultOpt()
    {
        val opts = ArrayList<TextView>()

        tvop1?.let {
            opts.add(0, it)
        }
            tvop2?.let {
                opts.add(1, it)
            }
        tvop3?.let {
            opts.add(2, it)
        }
        tvop4?.let {
            opts.add(3, it)
        }
        for (option in opts)
        {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.default_opbg)
        }


        }
    private fun selectedopt(tv:TextView,selectedoptionNum: Int) {

        mselectedpos=selectedoptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_opbg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.op1->{
                tvop1?.let {
                    selectedopt(it,1)
                }

            }
            R.id.op2-> {
                tvop2?.let {
                    selectedopt(it, 2)
                }
            }
            R.id.op3-> {
                tvop3?.let {
                    selectedopt(it, 3)
                }
            }
            R.id.op4-> {
                tvop4?.let {
                    selectedopt(it, 4)
                }
            }

            R.id.btn_submit->
            {
                if(mselectedpos==0)
                {
                    mcrtpos++
                    when{
                        mcrtpos<=mquesList!!.size->{
                            setQues()
                        }
                        else->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.CORRECT_ANS,mcorrectans)
                            intent.putExtra(Constants.total_ques,mquesList?.size)
                            startActivity(intent)
                            




                        }
                    }
                }else{
                    val ques=mquesList?.get(mcrtpos-1)
                    if(ques!!.crtans != mselectedpos){
                        answerView(mselectedpos,R.drawable.wrgans_opbg)
                    }
                    else {
                        mcorrectans++
                    }
                    answerView(ques.crtans,R.drawable.crtans_opbg)
                    if (mcrtpos==mquesList!!.size)
                        btn_submit?.text = "Finish"
                    else
                        btn_submit?.text = "GO TO NEXT QUES"
                    mselectedpos=0
                }
            }

        }


    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){

            1->{
                tvop1?.background= ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvop2?.background= ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvop3?.background= ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvop4?.background= ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}
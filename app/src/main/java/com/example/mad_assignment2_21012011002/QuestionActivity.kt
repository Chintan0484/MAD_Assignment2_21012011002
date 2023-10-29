package com.example.mad_assignment2_21012011002

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity() {

    private var questionList :ArrayList<QuestionData>?=null
    private var currentPosition :Int=1
    private var selectedOption : Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SetData.getQuestion()


        val opt1 = findViewById<TextView>(R.id.opt_1)
        val opt2 = findViewById<TextView>(R.id.opt_2)
        val opt3 = findViewById<TextView>(R.id.opt_3)
        val opt4 = findViewById<TextView>(R.id.opt_4)

        questionList = SetData.getQuestion()
        setQuestion()
         opt1.setOnClickListener{
             selectedOptionStyle(opt1,1)
         }
        opt2.setOnClickListener{
            selectedOptionStyle(opt2,2)
        }
        opt3.setOnClickListener{
            selectedOptionStyle(opt3,3)
        }
        opt4.setOnClickListener{
            selectedOptionStyle(opt4,4)
        }


    }

    @SuppressLint("SetTextI18n")
    fun setQuestion(){

        questionList!![currentPosition-1]
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val progressText = findViewById<TextView>(R.id.prgress_text)
        setOptionStyle()

        progressBar.progress=currentPosition
        progressBar.max=questionList!!.size
        progressText.text="${currentPosition}"+"/"+"${questionList!!.size}"

        val question_text = findViewById<TextView>(R.id.question_text)
        val que=questionList!![0]
        question_text.text=que.question

        val opt1 = findViewById<TextView>(R.id.opt_1)
        val opt2 = findViewById<TextView>(R.id.opt_2)
        val opt3 = findViewById<TextView>(R.id.opt_3)
        val opt4 = findViewById<TextView>(R.id.opt_4)

        opt1.text=que.option_one
        opt2.text=que.option_two
        opt3.text=que.option_three
        opt4.text=que.option_four
    }
    fun setOptionStyle(){
        val optionList:ArrayList<TextView> = arrayListOf()


        val opt1 = findViewById<TextView>(R.id.opt_1)
        val opt2 = findViewById<TextView>(R.id.opt_2)
        val opt3 = findViewById<TextView>(R.id.opt_3)
        val opt4 = findViewById<TextView>(R.id.opt_4)

        optionList.add(0,opt1)
        optionList.add(1,opt2)
        optionList.add(2,opt3)
        optionList.add(3,opt4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#605F5F"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface=Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView,opt:Int){

        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface=Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))




    }

}
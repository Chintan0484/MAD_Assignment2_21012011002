package com.example.mad_assignment2_21012011002

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text
class QuestionActivity : AppCompatActivity() {

    private var questionList :ArrayList<QuestionData>?=null
    private var currentPosition :Int=1
    private var selectedOption : Int=0

    val opt1 = findViewById<TextView>(R.id.opt_1)
    val opt2 = findViewById<TextView>(R.id.opt_2)
    val opt3 = findViewById<TextView>(R.id.opt_3)
    val opt4 = findViewById<TextView>(R.id.opt_4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SetData.getQuestion()

        questionList = SetData.getQuestion()
        setQuestion()

    }
    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val progressText = findViewById<TextView>(R.id.prgress_text)

        progressBar.progress=currentPosition
        progressBar.max=questionList!!.size
        progressText.text="${currentPosition}"+"/"+"${questionList!!.size}"

        val question_text = findViewById<TextView>(R.id.question_text)
        var que=questionList!![0]
        question_text.text=que.question



        opt1.text=que.option_one
        opt2.text=que.option_two
        opt3.text=que.option_three
        opt4.text=que.option_four
    }
    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()

        optionList.add(0,opt1)
        optionList.add(1,opt2)
        optionList.add(2,opt3)
        optionList.add(3,opt4)

        for (op in optionList)
        {
            op.setTextColors(Color.parseColor(""))
        }
    }
}
package com.example.mad_assignment2_21012011002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity() {

    private var questionList :ArrayList<QuestionData>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SetData.getQuestion()

        questionList = SetData.getQuestion()
        var que=questionList!![0]
        val question_text = findViewById<TextView>(R.id.question_text)
         question_text.text=que.question




    }
}
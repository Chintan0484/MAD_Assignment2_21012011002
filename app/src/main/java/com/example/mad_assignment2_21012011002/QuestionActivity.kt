package com.example.mad_assignment2_21012011002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SetData.getQuestion()

        val demo=SetData.getQuestion()

    }
}
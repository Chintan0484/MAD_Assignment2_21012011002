package com.example.mad_assignment2_21012011002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val userName=intent.getStringExtra(SetData.name)
        val score=intent.getStringExtra(SetData.score)
        val totalQuestion=intent.getStringExtra("total size")

        val congo = findViewById<TextView>(R.id.congo)
        val Score=findViewById<TextView>(R.id.Score)
        val finish=findViewById<Button>(R.id.btnFinish)

        congo.text="Congratulations ${userName} !!"
        Score.text="${score} / ${totalQuestion}"
        finish.setOnClickListener {
            finish()
        }

    }
}
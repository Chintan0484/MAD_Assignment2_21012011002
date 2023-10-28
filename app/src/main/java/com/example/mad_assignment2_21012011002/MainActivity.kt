package com.example.mad_assignment2_21012011002

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.TextView
import android.widget.Toast
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textinput=findViewById<TextView>(R.id.input)
        textinput.text=""

        val button:Button = findViewById(R.id.btnNext)
        button.setOnClickListener{
            if(textinput.text.toString().isEmpty())
            {
                Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this,QuestionActivity::class.java)
                intent.putExtra("${SetData.name}",textinput.text.toString())
                startActivity(intent)
                finish()
            }


        }
    }
}
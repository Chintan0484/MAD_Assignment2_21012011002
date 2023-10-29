package com.example.mad_assignment2_21012011002

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat



class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0

    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData> ? = null
    private var selecedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(SetData.name)

        questionList=SetData.getQuestion()

        setQuestion()
        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)

        opt_1.setOnClickListener{

            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{

            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{

            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{

            selectedOptionStyle(opt_4,4)
        }
        val submit =findViewById<Button>(R.id.btnSubmit)

        submit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selecedOption!=question.correct_ans)
                {
                    setColor(selecedOption,R.drawable.wrong_question_option)
                }else{
                    score++;
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if(currentPosition==questionList!!.size)
                    submit.text="FINISH"
                else
                    submit.text="Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,Result::class.java)
                        intent.putExtra(SetData.name,Name.toString())
                        intent.putExtra(SetData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption=0
        }

    }

    fun setColor(opt:Int,color:Int){
        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }


    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()

        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val progressText = findViewById<TextView>(R.id.prgress_text)
        val questionText = findViewById<TextView>(R.id.question_text)


        progressBar.progress=currentPosition
        progressBar.max=questionList!!.size
        progressText.text="${currentPosition}"+"/"+"${questionList!!.size}"
        questionText.text=question.question
        opt_1.text=question.option_one
        opt_2.text=question.option_two
        opt_3.text=question.option_three
        opt_4.text=question.option_four

    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()

        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)

        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView,opt:Int){

        setOptionStyle()
        selecedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}
package com.example.mad_assignment2_21012011002

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.jar.Attributes.Name

class QuestionActivity : AppCompatActivity() {

    private var questionList :ArrayList<QuestionData>?=null
    private var currentPosition :Int=1
    private var selectedOption : Int=0
    private var Name:String?=null
    private var score:Int=0


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

        val submit =findViewById<Button>(R.id.btnSubmit)
        submit.setOnClickListener{
            if (selectedOption!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selectedOption!=question.correct_ans)
                {
                    setColor(selectedOption,R.drawable.wrong_question_option)
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if (currentPosition==questionList!!.size)
                submit.text="FINISH"
                else
                    submit.text="GO TO NEXT"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent=Intent(this,ResultActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
            selectedOption=0
        }
    }
    val opt1 = findViewById<TextView>(R.id.opt_1)
    val opt2 = findViewById<TextView>(R.id.opt_2)
    val opt3 = findViewById<TextView>(R.id.opt_3)
    val opt4 = findViewById<TextView>(R.id.opt_4)

    fun setColor(opt:Int,color:Int)
    {
        when(opt){
            1->{
                opt1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt4.background=ContextCompat.getDrawable(this,color)
            }
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
package com.plcoding.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null
    private var mSelectedOptionPostion : Int = 0

    private var mUserName: String? =null
    private var mCorrectAnswers : Int=0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null

    private var tvQuestion :TextView? = null
    private var ivImage:  ImageView? = null


    private  var optionOne : TextView? = null
    private  var optionTwo : TextView? = null
    private  var optionThree: TextView? = null
    private  var optionFour : TextView? = null

    private var btn_Submit :Button? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        btn_Submit =findViewById(R.id.btn_submit)

        


        mQuestionList = Constants.getquestions()


        setQuestion()
        optionOne?.setOnClickListener(this) // setting the click listener to textview
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        btn_Submit?.setOnClickListener (this) //


    }

    private fun setQuestion() {
        defaultOptionsView()



        var question: Questions = mQuestionList!![mCurrentPosition-1] // !! is not null operator if you are sure questionlist is not null use this instead of ?
        ivImage?.setImageResource(question.image) // setting image
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour



        if(mCurrentPosition == mQuestionList!!.size){
            btn_Submit?.text = "FINISH"

        }else{
            btn_Submit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg
            )
        }


    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum : Int){
        defaultOptionsView()
        mSelectedOptionPostion = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                optionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two -> {
                optionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three -> {
                optionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                optionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPostion == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this,"YOU MADE TO THE END",Toast.LENGTH_LONG).show()
                            val intent = Intent(this,Result_activity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPostion){
                        answerView(mSelectedOptionPostion,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_Submit?.text = "FINISH"
                    }else{
                        btn_Submit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPostion=0
                }


            }
        }
    }

    private fun answerView(answer :Int , drawableView : Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
        }
    }
}
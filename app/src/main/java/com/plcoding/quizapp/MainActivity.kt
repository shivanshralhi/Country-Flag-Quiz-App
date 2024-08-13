package com.plcoding.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start : Button = findViewById(R.id.btn_start)
        val et_name : EditText = findViewById(R.id.et_text)
        btn_start.setOnClickListener {
            if(et_name.text.isEmpty()){
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()

            }else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())

                startActivity(intent)
                finish()
            }
        }
    }
}
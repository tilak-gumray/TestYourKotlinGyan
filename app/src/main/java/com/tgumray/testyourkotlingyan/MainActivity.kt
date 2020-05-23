package com.tgumray.testyourkotlingyan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tgumray.testyourkotlingyan.DBHelper.DBHelper
import kotlinx.android.synthetic.main.activity_main.*
import com.tgumray.testyourkotlingyan.common.Common
class MainActivity : AppCompatActivity() {

    private fun genQuestion(){
        Common.questionsList = DBHelper.getInstance(this).getQuestions()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        begintest.setOnClickListener {
            if(Common.questionsList.isEmpty())
                genQuestion()
            val intent = Intent(this@MainActivity,QuestionDisplay::class.java)
            startActivity(intent)


        }
    }
}

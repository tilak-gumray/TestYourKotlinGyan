package com.tgumray.testyourkotlingyan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tgumray.testyourkotlingyan.common.Common
import kotlinx.android.synthetic.main.activity_display_score.*

class DisplayScore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_score)

        for(question in Common.questionsList)
        {
            if(Common.answersList.containsKey(question.id))
            {
                if(question.answer.compareTo(Common.answersList.getValue(question.id),
                    false)==0)
                {
                    Common.score++
                }
            }
        }
        var displayscore: String = "${Common.score} out of ${Common.totalQuestions}"
        score.setText(displayscore)

        retry.setOnClickListener {
            Common.score = 0
            Common.answered = 0
            Common.answersList.clear()
            val intent = Intent(this@DisplayScore,MainActivity::class.java)
            startActivity(intent)

        }

        exit.setOnClickListener{
            Common.score = 0
            Common.answered = 0
            Common.answersList.clear()
            finishAffinity()
        }
    }
}

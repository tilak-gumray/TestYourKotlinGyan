package com.tgumray.testyourkotlingyan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.tgumray.testyourkotlingyan.common.Common
import com.tgumray.testyourkotlingyan.data.model.Question
import kotlinx.android.synthetic.main.activity_question_display.*

class QuestionDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_display)
        if(Common.answered == Common.totalQuestions-1) {
            next.visibility = View.INVISIBLE
            next.isEnabled = false
        }
        var question: Question = Question(0,"","","","","","")
        if(Common.answered <= Common.totalQuestions-1) {


            question = Common.questionsList[Common.answered]
            questiontext.setText(question.questionText)

            optionA.setText(question.optionA)
            optionB.setText(question.optionB)
            optionC.setText(question.optionC)
            optionD.setText(question.optionD)

        }

        radiogroup.setOnCheckedChangeListener{ group, checkedId ->

            val radio: RadioButton = group.findViewById(checkedId)
            if(!Common.answersList.containsKey(question.id))
                Common.answersList.put(question.id,radio.text.toString())


        }
        next.setOnClickListener {

            Common.answered++


            finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)

        }

        finish.setOnClickListener{
            finish()
            val intent = Intent(this@QuestionDisplay,DisplayScore::class.java)
            startActivity(intent)
        }
    }
}

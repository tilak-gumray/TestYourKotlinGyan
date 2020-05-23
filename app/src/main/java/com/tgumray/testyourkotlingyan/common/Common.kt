package com.tgumray.testyourkotlingyan.common
import com.tgumray.testyourkotlingyan.data.model.Question

object Common{
    var questionsList: List<Question> = ArrayList()
    var totalQuestions:Int = 10
    var answered:Int = 0
    var score:Int = 0
    var answersList: MutableMap<Int,String> = HashMap()
}
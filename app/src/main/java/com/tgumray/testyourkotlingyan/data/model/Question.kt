package com.tgumray.testyourkotlingyan.data.model

data class Question(
    var id:Int,
    var questionText:String,
    var optionA:String,
    var optionB:String,
    var optionC:String,
    var optionD:String,
    var answer:String
)
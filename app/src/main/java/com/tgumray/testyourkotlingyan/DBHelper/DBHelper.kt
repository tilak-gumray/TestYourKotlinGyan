package com.tgumray.testyourkotlingyan.DBHelper

import android.content.Context
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import com.tgumray.testyourkotlingyan.data.model.Question

class DBHelper(context: Context):SQLiteAssetHelper(context,DB_NAME,null,DB_VER)
{
companion object{
    private var instance :DBHelper?=null
    private var DB_NAME = "Questions.db"
    private var DB_VER = 1

    @Synchronized
    fun getInstance(context: Context):DBHelper{
        if(instance == null)
            instance = DBHelper(context)
        return instance!!
    }
}

    fun getQuestions():List<Question>{

        val db:SQLiteDatabase = instance!!.writableDatabase
        val cursor:Cursor = db.rawQuery("SELECT * FROM Question",null)
        val questionList = ArrayList<Question>()
        if(cursor.moveToFirst())
        {
            while(!cursor.isAfterLast()){
                val question = Question(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("QuestionText")),
                    cursor.getString(cursor.getColumnIndex("OptionA")),
                    cursor.getString(cursor.getColumnIndex("OptionB")),
                    cursor.getString(cursor.getColumnIndex("OptionC")),
                    cursor.getString(cursor.getColumnIndex("OptionD")),
                    cursor.getString(cursor.getColumnIndex("Answer"))
                    )
                questionList.add(question)
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()

        return questionList
    }
}
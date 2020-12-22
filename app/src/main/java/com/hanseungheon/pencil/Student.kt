package com.hanseungheon.pencil

import android.util.Log

class Student(var studentName:String, var studentGender:Int, var isStudentAlive:Boolean,var id: Int):Person(studentName, studentGender, isStudentAlive) {
    fun study(subject:String){
        Log.d(studentName,"${subject}를 공부한다" )
    }

}
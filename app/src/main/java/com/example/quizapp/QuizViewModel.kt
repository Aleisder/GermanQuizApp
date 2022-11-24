package com.example.quizapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.Quiz

class QuizViewModel : ViewModel() {

    private var tasks = Quiz().tasks.shuffled().toMutableList()
    private val allTasksAmount = tasks.size
    private var correctAnswers = 0

    private var _taskNumber = MutableLiveData(1)
    val taskNumber: LiveData<Int> get() = _taskNumber

    fun dropLastQuestion() {
        tasks.removeLast()
    }

    fun getRestTasksAmount() = tasks.size

    fun getCurrentTask() = tasks.last()

    fun restartViewModel() {
        tasks = Quiz().tasks.shuffled().toMutableList()
        correctAnswers = 0
        _taskNumber = MutableLiveData(0)
    }

    fun increaseCorrectAnswersAmount() {
        correctAnswers++
    }

    fun increaseTaskNumber() {
        _taskNumber.value = _taskNumber.value!!.plus(1)
        Log.d("sgf", taskNumber.value!!.toString())
    }

    fun getCorrectAnswers() = correctAnswers

    fun getAllTasksAmount() = allTasksAmount

}



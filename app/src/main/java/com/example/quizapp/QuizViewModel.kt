package com.example.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.Quiz

class QuizViewModel : ViewModel() {

    private val tasks = Quiz().tasks.shuffled().toMutableList()

    private var _rightAnswersAmount = MutableLiveData(0)
    val rightAnswersAmount: LiveData<Int> = _rightAnswersAmount

    fun dropLastQuestion() {
        tasks.removeLast()
    }

    fun getQuestionsAmount() = tasks.size

    fun getCurrentTask() = tasks.last()

}



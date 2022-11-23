package com.example.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.Quiz

class QuizViewModel : ViewModel() {

    val tasks = Quiz().tasks

    private var _rightAnswersAmount = MutableLiveData(0)
    val rightAnswersAmount: LiveData<Int> = _rightAnswersAmount

}



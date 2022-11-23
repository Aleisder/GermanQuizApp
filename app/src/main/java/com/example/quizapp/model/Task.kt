package com.example.quizapp.model

data class Task(
    val question: String,
    val answer: String,
    val variants: List<String>
)
package com.example.quizapp.data

import com.example.quizapp.model.Task

class Quiz {

    val tasks = listOf(
        Task(
            question = "Ich ... Alex",
            answer = "heiße",
            variants = listOf("heißen", "heißt", "heiße", "heisest")
        ),
        Task(
            question = "Er ... achtzehn Jahre alt",
            answer = "ist",
            variants = listOf("bist", "bin", "sind", "ist")
        ),
        Task(
            question = "Sie hat ... Bruder",
            answer = "ein",
            variants = listOf("ein", "eine", "eins", "einen")
        ),
        Task(
            question = "Du ... gestern gesungen",
            answer = "hast",
            variants = listOf("hast", "habe", "hat", "haben")
        ),
        Task(
            question = "... ist der Zebrastreifen?",
            answer = "Wo",
            variants = listOf("Was", "Wann", "Wie", "Wo")
        ),
        Task(
            question = "neun, zehn, elf, ...",
            answer = "zwölf",
            variants = listOf("dreizehn", "acht", "vierzehn", "zwölf")
        )
    )

}
package com.example.sudoku.domain

enum class Difficulty(val modifier: Double) {
    EASY(modifier = 0.5),
    MEDIUM(modifier = 0.44),
    HARD(modifier = 0.38)
}
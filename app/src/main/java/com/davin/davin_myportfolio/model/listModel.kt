package com.davin.davin_myportfolio.model

data class EducationModel(
    val institute: String,
    val level: String,
    val majors: String,
    val years: String,
    val img: String
)

data class WorkModel(
    val company: String,
    val duration: String,
    val role: String,
    val status: String,
    val years: String
)
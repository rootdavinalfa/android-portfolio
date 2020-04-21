/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

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

data class SnsModel(val name: String, val url: String, val img: String)

data class SkillsModel(val name: String, val certification: String)
package org.mbds.unice.github.data.model

import java.time.LocalDate

data class User(
    val id: String,
    val login: String,
    val avatarUrl: String,
    var isActive: Boolean,
    val creationDate: LocalDate
)
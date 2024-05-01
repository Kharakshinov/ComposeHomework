package ru.project.composehomework

data class Contact(
    val name: String,
    val surname: String? = null,
    val familyName: String,
    val imageRes: Int? = null,
    val isFavorite: Boolean = false,
    val phone: String? = null,
    val address: String,
    val email: String? = null,
)
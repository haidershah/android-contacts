package com.example.contacts.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String
) : Parcelable

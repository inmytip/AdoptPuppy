package com.inmytip.adoptpuppy.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Puppy(
    val id: Int,
    @StringRes val breedId: Int,
    @StringRes val farmId: Int,
    @DrawableRes val imageId: Int,
    val gender: Int
    )

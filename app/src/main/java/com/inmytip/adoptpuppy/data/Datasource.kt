package com.inmytip.adoptpuppy.data

import com.inmytip.adoptpuppy.model.Puppy
import com.inmytip.adoptpuppy.R

class Datasource {

    fun loadPuppies(): List<Puppy> {
        return listOf(
            Puppy(0, R.string.puppy1, R.string.farm1, R.drawable.puppy_1, 2),
            Puppy(1, R.string.puppy4, R.string.farm2, R.drawable.puppy_4, 2),
            Puppy(2, R.string.puppy7, R.string.farm3, R.drawable.puppy_7, 1),
            Puppy(3, R.string.puppy14, R.string.farm4, R.drawable.puppy_14, 2),
            Puppy(4, R.string.puppy2, R.string.farm1, R.drawable.puppy_2, 1),
            Puppy(5, R.string.puppy5, R.string.farm2, R.drawable.puppy_5, 1),
            Puppy(6, R.string.puppy8, R.string.farm3, R.drawable.puppy_8, 1),
            Puppy(7, R.string.puppy15, R.string.farm4, R.drawable.puppy_15, 2),
            Puppy(8, R.string.puppy3, R.string.farm1, R.drawable.puppy_3, 1),
            Puppy(9, R.string.puppy6, R.string.farm2, R.drawable.puppy_6, 2),
            Puppy(10, R.string.puppy9, R.string.farm3, R.drawable.puppy_9, 2),
            Puppy(11, R.string.puppy16, R.string.farm4, R.drawable.puppy_16, 2),
            Puppy(12, R.string.puppy10, R.string.farm3, R.drawable.puppy_10, 1),
            Puppy(13, R.string.puppy17, R.string.farm4, R.drawable.puppy_17, 1),
            Puppy(14, R.string.puppy11, R.string.farm3, R.drawable.puppy_11, 2),
            Puppy(15, R.string.puppy18, R.string.farm4, R.drawable.puppy_18, 2),
            Puppy(16, R.string.puppy12, R.string.farm3, R.drawable.puppy_12, 1),
            Puppy(17, R.string.puppy19, R.string.farm4, R.drawable.puppy_19, 1),
            Puppy(18, R.string.puppy13, R.string.farm3, R.drawable.puppy_13, 1),
            Puppy(19, R.string.puppy20, R.string.farm4, R.drawable.puppy_20, 1)
        )
    }
    
}
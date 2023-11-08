package com.example.khabar.domain.manager

import kotlinx.coroutines.flow.Flow

/**
 * In this interface, we will save the app entry when user click on get started in the last onBoarding screen.
 * Created this interface because now this repository is now testable because we can actually fake this one
 * and create a fake repository data layer. That's why we create a interface inside the domain layer
 * */
interface LocalUserManager {

    suspend fun saveApEntry()

    /** to read value of above function we will create another function readAppEntry that will return a flow.*/
    fun readAppEntry(): Flow<Boolean>

}


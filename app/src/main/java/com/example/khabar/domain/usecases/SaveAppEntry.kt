package com.example.khabar.domain.usecases

import com.example.khabar.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    /** Creating operator function so that we can call this function by the name of this class.*/
    suspend operator fun invoke(){
        localUserManager.saveApEntry()
    }
}
package com.example.khabar.domain.usecases

import com.example.khabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }

}
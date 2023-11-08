package com.example.khabar.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.khabar.domain.manager.LocalUserManager
import com.example.khabar.util.Constants
import com.example.khabar.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * Now here we will going to implement data store preferences.
 * data store preferences: is just a jetpack library that allows us to a value locally on the device.
 * SharedPreference API is also same just the android team introduced us this new API to save key value
 * which is now recommended.
 * */
class LocalUserManagerImplementation(private val context: Context): LocalUserManager {
    override suspend fun saveApEntry() {
        context.datastore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map {preferences ->
            preferences[PreferencesKey.APP_ENTRY]?: false
        }
    }
}


// getting instance from datastore
private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKey{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
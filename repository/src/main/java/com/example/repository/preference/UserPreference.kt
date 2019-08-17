package com.example.repository.preference

import com.example.usecases.repository.UserRepositoryPreference
import com.kkroco.repository.preference.manager.PreferencesManager
import pe.solera.repository.preference.utils.PREFERENCE_TOKEN


class UserPreference(private val sharedPreferenceManager: PreferencesManager) : UserRepositoryPreference {
    override fun saveToken(token: String) {
        sharedPreferenceManager.setValue(PREFERENCE_TOKEN, token)
    }

    override fun getToken(): String {
        return sharedPreferenceManager.getString(PREFERENCE_TOKEN)
    }
}
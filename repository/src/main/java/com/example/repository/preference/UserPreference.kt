package pe.solera.repository.preference

import com.kkroco.repository.preference.manager.PreferencesManager
import pe.solera.repository.preference.utils.PREFERENCE_TOKEN
import pe.solera.usecases.repository.UserRepositoryPreference


class UserPreference(private val sharedPreferenceManager: PreferencesManager) : UserRepositoryPreference {
    override fun saveToken(token: String) {
        sharedPreferenceManager.setValue(PREFERENCE_TOKEN, token)
    }

    override fun getToken(): String {
        return sharedPreferenceManager.getString(PREFERENCE_TOKEN)
    }
}
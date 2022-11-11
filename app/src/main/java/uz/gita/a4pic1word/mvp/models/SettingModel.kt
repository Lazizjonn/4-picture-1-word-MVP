package uz.gita.a4pic1word.mvp.models

import uz.gita.a4pic1word.data.repository.Repository
import uz.gita.a4pic1word.mvp.contracts.SettingsContract


class SettingModel : SettingsContract.Model {

    private val repository by lazy { Repository.getRepository() }

    override fun getSoundState(): Boolean = repository.getSoundState()

    override fun saveSoundState(state: Boolean) = kotlin.run { repository.setSoundState(state) }
}
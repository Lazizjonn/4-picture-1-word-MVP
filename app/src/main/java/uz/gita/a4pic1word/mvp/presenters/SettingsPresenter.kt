package uz.gita.a4pic1word.mvp.presenters

import uz.gita.a4pic1word.mvp.contracts.SettingsContract
import uz.gita.a4pic1word.mvp.models.SettingModel


class SettingsPresenter(private val view: SettingsContract.View) : SettingsContract.Presenter {
    private val model: SettingsContract.Model = SettingModel()

    override fun init() = kotlin.run { view.setSoundState(model.getSoundState()) }

    override fun changeSoundState(state: Boolean) = kotlin.run { model.saveSoundState(state) }

}

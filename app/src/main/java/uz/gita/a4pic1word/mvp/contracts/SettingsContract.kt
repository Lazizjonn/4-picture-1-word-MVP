package uz.gita.a4pic1word.mvp.contracts


interface SettingsContract {

    interface Model {
        fun getSoundState(): Boolean
        fun saveSoundState(state: Boolean)
    }

    interface View {
        fun setSoundState(state: Boolean)
        fun emitSoundOnClickButton()
    }

    interface Presenter {
        fun init()
        fun changeSoundState(state: Boolean)
    }

}
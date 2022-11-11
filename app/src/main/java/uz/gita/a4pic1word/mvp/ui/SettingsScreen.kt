package uz.gita.a4pic1word.mvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import uz.gita.a4pic1word.R
import uz.gita.a4pic1word.mvp.contracts.SettingsContract
import uz.gita.a4pic1word.mvp.presenters.SettingsPresenter


class SettingsScreen : AppCompatActivity(), SettingsContract.View {

    /* private var _binding: ScreeSettingsBinding? =null
     private val binding get() = _binding!!
     */
    private lateinit var soundState: SwitchMaterial
    private lateinit var presenter: SettingsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scree_settings)
        loadViews()
        presenter = SettingsPresenter(this)
        presenter.init()
    }

    private fun loadViews() {
        soundState = findViewById(R.id.sound)
        soundState.setOnCheckedChangeListener { _, isChecked ->
            presenter.changeSoundState(isChecked)
        }
    }

    override fun setSoundState(state: Boolean) {
        soundState.isChecked = state
    }

    override fun emitSoundOnClickButton() {
        TODO("Not yet implemented")
    }
}
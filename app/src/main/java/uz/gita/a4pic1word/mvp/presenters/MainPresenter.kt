package uz.gita.a4pic1word.mvp.presenters

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import uz.gita.a4pic1word.mvp.contracts.MainContract
import uz.gita.a4pic1word.mvp.models.MainModel


class MainPresenter (private val view: MainContract.View) : MainContract.Presenter {
    private val model: MainContract.Model = MainModel()

    override fun init() {
        Log.d("TTT", "init()")
        view.setCurrentCoins(model.getCurrentCoins())
        view.setCurrentQuestionPosition(model.getQuestionPosition()+1)
        view.setImages(model.getImages())
    }

    override fun onClickStart() {
        Log.d("TTT", "onClickStart()")
        view.navigateToGamScreen()
    }

    // TODO (later)
    override fun onClickSettings() {
        Log.d("TTT", "onClickSettings()")
        view.navigateToSettingsScreen()
    }

    override fun onClickRate() {
        view.rateApp()
    }

    override fun onClickContact() {
        view.contactUs()
    }

    override fun onClickShare() {
        view.shareApp()
    }


}
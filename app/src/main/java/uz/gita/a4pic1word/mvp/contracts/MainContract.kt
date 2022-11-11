package uz.gita.a4pic1word.mvp.contracts


// Model | View | Presenter
interface MainContract {

    interface Model {
        fun getImages(): List<Int>
        fun getQuestionPosition(): Int
        fun getCurrentCoins(): Int
    }

    interface View {
        fun navigateToGamScreen()
        fun navigateToSettingsScreen()

        fun setCurrentQuestionPosition(position: Int)
        fun setImages(images: List<Int>)
        fun setCurrentCoins(coins: Int)

        fun contactUs(): Boolean
        fun shareApp(): Boolean
        fun rateApp()


    }

    interface Presenter {
        fun init()
        fun onClickStart()
        fun onClickSettings()
        fun onClickRate()
        fun onClickContact()
        fun onClickShare()
    }

}
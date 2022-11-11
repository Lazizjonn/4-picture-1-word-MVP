package uz.gita.a4pic1word.mvp.contracts

import uz.gita.a4pic1word.data.data.QuestionData


// Model | View | Presenter
interface GameContract {

    interface Model {
        fun getDataByPosition(position: Int): QuestionData
        fun getCurrentQuestionPosition(): Int
        fun getCurrentCoins(): Int

        fun saveQuestionPosition(position: Int)
        fun saveCurrentCoins()

        fun canGetDataByPosition(position: Int): Boolean
    }

    interface View {
        fun setCurrentQuestionPosition(position: Int)
        fun setCurrentCoinsValue(coins: Int)

        fun setImagesByPosition(images: List<Int>)
        fun setCurrentAnswerLength(length: Int)
        fun setVariantsByPosition(variant: List<Char>)
        fun clearAnswersAndVariants()

        fun disableAnswerButtonByPosition(position: Int)
        fun disableVariantButtonByPosition(position: Int)
        fun setLetterToAnswerButtonByPosition(position: Int, letter: Char)
        fun setLetterToVariantButtonByPosition(position: Int, letter: Char)

        fun playAnimButtonAnswer(position: Int)
        fun playAnimButtonVariant(position: Int)
        fun playAnimWrongAnswer()

        fun correctAnswer()
        fun onClickBackButton()
    }

    interface Presenter {
        fun init()
        fun loadData()

        fun clickedAnswerButton(position: Int)
        fun clickedVariantButton(position: Int)

        fun onClickBack()
    }

}
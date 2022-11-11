package uz.gita.a4pic1word.mvp.presenters

import android.util.Log
import uz.gita.a4pic1word.data.local.MySharedPreferences
import uz.gita.a4pic1word.mvp.contracts.GameContract
import uz.gita.a4pic1word.mvp.models.GameModel


class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {

    private val model: GameContract.Model = GameModel()

    private val images: ArrayList<Int> = ArrayList()

    private var currentPosition: Int = 0
    private var answer: String = ""
    private var variant: String = ""

    private var tagAnswer: StringBuilder = StringBuilder()
    private var tagVariant: StringBuilder = StringBuilder()

    override fun init() {
        Log.d(
            "TTT",
            "MySharedPreferences.getMyPreferences().currentPosition ${MySharedPreferences.getMyPreferences().currentPosition}"
        )
        currentPosition = model.getCurrentQuestionPosition()
        loadData()
    }

    override fun loadData() {
        if (!model.canGetDataByPosition(currentPosition)) {
            currentPosition = 0
            model.saveQuestionPosition(currentPosition)
        }

        view.clearAnswersAndVariants()

        val data = model.getDataByPosition(currentPosition)

        answer = data.answer
        tagAnswer = StringBuilder("########".substring(0, data.answer.length))
        variant = data.variant
        tagVariant = StringBuilder("############")

        images.clear()
        images.add(data.image1)
        images.add(data.image2)
        images.add(data.image3)
        images.add(data.image4)

        view.setCurrentQuestionPosition(currentPosition + 1)
        view.setCurrentCoinsValue(model.getCurrentCoins())
        view.setImagesByPosition(images)
        view.setCurrentAnswerLength(data.answer.length)
        view.setVariantsByPosition(data.variant.toList())
    }

    override fun clickedAnswerButton(position: Int) {
        view.playAnimButtonAnswer(position)
        val letter = tagAnswer[position]
        Log.d("TTT", "___________________________________")
        Log.d("TTT", "letter: $letter")
        val indexOfTagVariant = tagVariant.indexOf(letter)
        val indexOfTagAnswer = tagAnswer.indexOf("#")
        Log.d("TTT", "indexOfTagVariant: $indexOfTagVariant")
        tagVariant.setCharAt(indexOfTagVariant, '#')
        Log.d("TTT", "tagVariant: $tagVariant")
        tagAnswer.setCharAt(position, '#')
        Log.d("TTT", "tagAnswer: $tagAnswer")
        view.disableAnswerButtonByPosition(position)
        view.setLetterToVariantButtonByPosition(indexOfTagVariant, letter)
    }

    override fun clickedVariantButton(position: Int) {
        val letter = variant[position]
        Log.d("TTT", "___________________________________")
        Log.d("TTT", "letter: $letter")
        val indexOfTagAnswer = tagAnswer.indexOf("#")
        Log.d("TTT", "indexOfTagAnswer: $indexOfTagAnswer")
        if (indexOfTagAnswer >= 0) {
            view.playAnimButtonVariant(position)
            tagAnswer.setCharAt(indexOfTagAnswer, letter)
            Log.d("TTT", "tagAnswer: $tagAnswer")
            tagVariant.setCharAt(position, letter)
            Log.d("TTT", "tagVariant: $tagVariant")
            view.setLetterToAnswerButtonByPosition(indexOfTagAnswer, letter)
            view.disableVariantButtonByPosition(position)
        }
        if (hasFinished()) check()
    }

    private fun hasFinished(): Boolean = !tagAnswer.toString().contains("#")

    private fun check() {
        when (answer) {
            tagAnswer.toString() -> {
                model.saveCurrentCoins()
                currentPosition++
                model.saveQuestionPosition(currentPosition)
                view.correctAnswer()
            }
            else -> view.playAnimWrongAnswer()
        }
    }

    override fun onClickBack() {
        view.onClickBackButton()
    }

}
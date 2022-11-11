package uz.gita.a4pic1word.mvp.models

import uz.gita.a4pic1word.data.data.QuestionData
import uz.gita.a4pic1word.data.repository.Repository
import uz.gita.a4pic1word.mvp.contracts.GameContract
import uz.gita.a4pic1word.utils.DefaultValues


class GameModel : GameContract.Model {

    private val repository: Repository = Repository.getRepository()

    override fun getDataByPosition(position: Int): QuestionData =
        repository.getDataByPosition(position)

    override fun getCurrentQuestionPosition(): Int = repository.getCurrentQuestionPosition()

    override fun getCurrentCoins(): Int = repository.getCurrentCoins()

    override fun saveQuestionPosition(position: Int) =
        repository.saveCurrentQuestionPosition(position)

    override fun saveCurrentCoins() {
        repository.saveCurrentCoins(DefaultValues.WINNER_COINS.result)
    }

    override fun canGetDataByPosition(position: Int): Boolean = repository.isAvailableDataByPosition(position)
}
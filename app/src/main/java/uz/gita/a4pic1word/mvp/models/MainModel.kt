package uz.gita.a4pic1word.mvp.models

import uz.gita.a4pic1word.data.repository.Repository
import uz.gita.a4pic1word.mvp.contracts.MainContract


class MainModel : MainContract.Model {
    private val repository: Repository = Repository.getRepository()

    override fun getImages(): List<Int> {
        val position = repository.getCurrentQuestionPosition()
        val data = repository.getDataByPosition(position)

        val images = ArrayList<Int>()
        images.add(data.image1)
        images.add(data.image2)
        images.add(data.image3)
        images.add(data.image4)
        return images
    }

    override fun getQuestionPosition(): Int = repository.getCurrentQuestionPosition()

    override fun getCurrentCoins(): Int  = repository.getCurrentCoins()
}
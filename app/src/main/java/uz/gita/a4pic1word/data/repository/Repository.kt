package uz.gita.a4pic1word.data.repository

import uz.gita.a4pic1word.R
import uz.gita.a4pic1word.data.data.QuestionData
import uz.gita.a4pic1word.data.local.MySharedPreferences


class Repository {
    private val questionsList: ArrayList<QuestionData> = ArrayList()

    init {
        loadData()
    }

    companion object {
        private var repository: Repository? = null

        fun initRepository() {
            if (repository != null) return
            else {
                repository = Repository()
            }
        }

        fun getRepository(): Repository {
            return repository!!
        }
    }

    private fun loadData() {

        questionsList.add(
            QuestionData(
                id = 1,
                image1 = R.drawable.animal_10_1_owl,
                image2 = R.drawable.animal_10_2_owl,
                image3 = R.drawable.animal_10_3_owl,
                image4 = R.drawable.animal_10_4_owl,
                answer = "OWL",
                variant = "WEODLJGBNMZX"
            )
        )

        questionsList.add(
            QuestionData(
                id = 2,
                image1 = R.drawable.classroom_2_1_bag,
                image2 = R.drawable.classroom_2_2_bag,
                image3 = R.drawable.classroom_2_3_bag,
                image4 = R.drawable.classroom_2_4_bag,
                answer = "BAG",
                variant = "QPBFENGERILA"
            )
        )

        questionsList.add(
            QuestionData(
                id = 3,
                image1 = R.drawable.animal_5_1_lion,
                image2 = R.drawable.animal_5_2_lion,
                image3 = R.drawable.animal_5_3_lion,
                image4 = R.drawable.animal_5_4_lion,
                answer = "LION",
                variant = "OFDOERINBDKL"
            )
        )

        questionsList.add(
            QuestionData(
                id = 4,
                image1 = R.drawable.animal_9_1_duck,
                image2 = R.drawable.animal_9_2_duck,
                image3 = R.drawable.animal_9_3_duck,
                image4 = R.drawable.animal_9_4_duck,
                answer = "DUCK",
                variant = "QHTSKCUDKPQW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 5,
                image1 = R.drawable.classroom_5_1_desk,
                image2 = R.drawable.classroom_5_2_desk,
                image3 = R.drawable.classroom_5_3_desk,
                image4 = R.drawable.classroom_5_4_desk,
                answer = "DESK",
                variant = "SPBFEDGERICK"
            )
        )

        questionsList.add(
            QuestionData(
                id = 6,
                image1 = R.drawable.classroom_6_1_book,
                image2 = R.drawable.classroom_6_2_book,
                image3 = R.drawable.classroom_6_3_book,
                image4 = R.drawable.classroom_6_4_book,
                answer = "BOOK",
                variant = "OPBFEOGERICK"
            )
        )

        questionsList.add(
            QuestionData(
                id = 7,
                image1 = R.drawable.classroom_8_1_glue,
                image2 = R.drawable.classroom_8_2_glue,
                image3 = R.drawable.classroom_8_3_glue,
                image4 = R.drawable.classroom_8_4_glue,
                answer = "GLUE",
                variant = "EPLAEOGERIRU"
            )
        )

        questionsList.add(
            QuestionData(
                id = 8,
                image1 = R.drawable.color_4_1_blue,
                image2 = R.drawable.color_4_2_blue,
                image3 = R.drawable.color_4_3_blue,
                image4 = R.drawable.color_4_4_blue,
                answer = "BLUE",
                variant = "ELOATBKECLNU"
            )
        )

        questionsList.add(
            QuestionData(
                id = 9,
                image1 = R.drawable.color_6_1_pink,
                image2 = R.drawable.color_6_2_pink,
                image3 = R.drawable.color_6_3_pink,
                image4 = R.drawable.color_6_4_pink,
                answer = "PINK",
                variant = "PLIALOKKCLNW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 10,
                image1 = R.drawable.color_9_1_grey,
                image2 = R.drawable.color_9_2_grey,
                image3 = R.drawable.color_9_3_grey,
                image4 = R.drawable.color_9_4_grey,
                answer = "GREY",
                variant = "GLRALEKYCLNW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 11,
                image1 = R.drawable.color_10_1_brown,
                image2 = R.drawable.color_10_2_brown,
                image3 = R.drawable.color_10_3_brown,
                image4 = R.drawable.color_10_4_brown,
                answer = "BROWN",
                variant = "GNRWLEOYRLNB"
            )
        )

        questionsList.add(
            QuestionData(
                id = 12,
                image1 = R.drawable.animal_2_1_zebra,
                image2 = R.drawable.animal_2_2_zebra,
                image3 = R.drawable.animal_2_3_zebra,
                image4 = R.drawable.animal_2_4_zebra,
                answer = "ZEBRA",
                variant = "QWZDNEFBHRJA"
            )
        )

        questionsList.add(
            QuestionData(
                id = 13,
                image1 = R.drawable.classroom_3_1_chair,
                image2 = R.drawable.classroom_3_2_chair,
                image3 = R.drawable.classroom_3_3_chair,
                image4 = R.drawable.classroom_3_4_chair,
                answer = "CHAIR",
                variant = "RHBFEIGERICA"
            )
        )

        questionsList.add(
            QuestionData(
                id = 14,
                image1 = R.drawable.animal_6_1_tiger,
                image2 = R.drawable.animal_6_2_tiger,
                image3 = R.drawable.animal_6_3_tiger,
                image4 = R.drawable.animal_6_4_tiger,
                answer = "TIGER",
                variant = "REGFVKFIVITP"
            )
        )

        questionsList.add(
            QuestionData(
                id = 15,
                image1 = R.drawable.color_1_1_black,
                image2 = R.drawable.color_1_2_black,
                image3 = R.drawable.color_1_3_black,
                image4 = R.drawable.color_1_4_black,
                answer = "BLACK",
                variant = "SLOATBKECKNO"
            )
        )

        questionsList.add(
            QuestionData(
                id = 16,
                image1 = R.drawable.classroom_4_1_board,
                image2 = R.drawable.classroom_4_2_board,
                image3 = R.drawable.classroom_4_3_board,
                image4 = R.drawable.classroom_4_4_board,
                answer = "BOARD",
                variant = "OPBFEDGERICA"
            )
        )

        questionsList.add(
            QuestionData(
                id = 17,
                image1 = R.drawable.animal_7_1_camel,
                image2 = R.drawable.animal_7_2_camel,
                image3 = R.drawable.animal_7_3_camel,
                image4 = R.drawable.animal_7_4_camel,
                answer = "CAMEL",
                variant = "ASQCWMDFMZEL"
            )
        )

        questionsList.add(
            QuestionData(
                id = 18,
                image1 = R.drawable.color_2_1_white,
                image2 = R.drawable.color_2_2_white,
                image3 = R.drawable.color_2_3_white,
                image4 = R.drawable.color_2_4_white,
                answer = "WHITE",
                variant = "SEOATBKHCINW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 19,
                image1 = R.drawable.animal_8_1_shark,
                image2 = R.drawable.animal_8_2_shark,
                image3 = R.drawable.animal_8_3_shark,
                image4 = R.drawable.animal_8_4_shark,
                answer = "SHARK",
                variant = "QHTSAIRLKPQW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 20,
                image1 = R.drawable.color_3_1_green,
                image2 = R.drawable.color_3_2_green,
                image3 = R.drawable.color_3_3_green,
                image4 = R.drawable.color_3_4_green,
                answer = "GREEN",
                variant = "GROAEBKECKNO"
            )
        )

        questionsList.add(
            QuestionData(
                id = 21,
                image1 = R.drawable.animal_1_1_panda,
                image2 = R.drawable.animal_1_2_panda,
                image3 = R.drawable.animal_1_3_panda,
                image4 = R.drawable.animal_1_4_panda,
                answer = "PANDA",
                variant = "IPTNGYDIAQTA"
            )
        )

        questionsList.add(
            QuestionData(
                id = 22,
                image1 = R.drawable.classroom_1_1_pencil,
                image2 = R.drawable.classroom_1_2_pencil,
                image3 = R.drawable.classroom_1_3_pencil,
                image4 = R.drawable.classroom_1_4_pencil,
                answer = "PENCIL",
                variant = "QPDFENCERILK"
            )
        )

        questionsList.add(
            QuestionData(
                id = 23,
                image1 = R.drawable.color_5_1_yellow,
                image2 = R.drawable.color_5_2_yellow,
                image3 = R.drawable.color_5_3_yellow,
                image4 = R.drawable.color_5_4_yellow,
                answer = "YELLOW",
                variant = "ELYALOKECLNW"
            )
        )

        questionsList.add(
            QuestionData(
                id = 24,
                image1 = R.drawable.animal_4_1_monkey,
                image2 = R.drawable.animal_4_2_monkey,
                image3 = R.drawable.animal_4_3_monkey,
                image4 = R.drawable.animal_4_4_monkey,
                answer = "MONKEY",
                variant = "QNKTEZOSYBMP"
            )
        )

        questionsList.add(
            QuestionData(
                id = 25,
                image1 = R.drawable.color_7_1_purple,
                image2 = R.drawable.color_7_2_purple,
                image3 = R.drawable.color_7_3_purple,
                image4 = R.drawable.color_7_4_purple,
                answer = "PURPLE",
                variant = "PLIALEKPCRNU"
            )
        )

        questionsList.add(
            QuestionData(
                id = 26,
                image1 = R.drawable.classroom_7_1_eraser,
                image2 = R.drawable.classroom_7_2_eraser,
                image3 = R.drawable.classroom_7_3_eraser,
                image4 = R.drawable.classroom_7_4_eraser,
                answer = "ERASER",
                variant = "EPBAEOGERIRS"
            )
        )

        questionsList.add(
            QuestionData(
                id = 27,
                image1 = R.drawable.color_8_1_orange,
                image2 = R.drawable.color_8_2_orange,
                image3 = R.drawable.color_8_3_orange,
                image4 = R.drawable.color_8_4_orange,
                answer = "ORANGE",
                variant = "ELIALOGKCLNR"
            )
        )

        questionsList.add(
            QuestionData(
                id = 28,
                image1 = R.drawable.classroom_9_1_scissor,
                image2 = R.drawable.classroom_9_2_scissor,
                image3 = R.drawable.classroom_9_3_scissor,
                image4 = R.drawable.classroom_9_4_scissor,
                answer = "SCISSOR",
                variant = "SCLASSGERIRO"
            )
        )

        questionsList.add(
            QuestionData(
                id = 29,
                image1 = R.drawable.animal_3_1_giraffe,
                image2 = R.drawable.animal_3_2_giraffe,
                image3 = R.drawable.animal_3_3_giraffe,
                image4 = R.drawable.animal_3_4_giraffe,
                answer = "GIRAFFE",
                variant = "EFFKGBGAPRIG"
            )
        )

        questionsList.add(
            QuestionData(
                id = 30,
                image1 = R.drawable.classroom_10_1_notebook,
                image2 = R.drawable.classroom_10_2_notebook,
                image3 = R.drawable.classroom_10_3_notebook,
                image4 = R.drawable.classroom_10_4_notebook,
                answer = "NOTEBOOK",
                variant = "SOOATBKERINO"
            )
        )
    }

    // connection with data
    fun getDataByPosition(position: Int): QuestionData = questionsList[position]

    // connection with data
    fun isAvailableDataByPosition(position: Int): Boolean = questionsList.size - 1 >= position

    // connection with sharedPreferences
    fun saveCurrentQuestionPosition(position: Int) =
        kotlin.run { MySharedPreferences.getMyPreferences().currentPosition = position }

    // connection with sharedPreferences
    fun getCurrentQuestionPosition(): Int = MySharedPreferences.getMyPreferences().currentPosition

    // connection with sharedPreferences
    fun saveCurrentCoins(coins: Int) = kotlin.run {
        MySharedPreferences.getMyPreferences().currentCoins = coins
    }

    // connection with sharedPreferences
    fun getSoundState(): Boolean = MySharedPreferences.getMyPreferences().sound

    // connection with sharedPreferences
    fun setSoundState(state: Boolean) =
        kotlin.run { MySharedPreferences.getMyPreferences().sound = state }

    // connection with sharedPreferences
    fun getCurrentCoins(): Int = MySharedPreferences.getMyPreferences().currentCoins
}
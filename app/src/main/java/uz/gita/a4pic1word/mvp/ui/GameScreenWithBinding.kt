package uz.gita.a4pic1word.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.balysv.materialripple.MaterialRippleLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import uz.gita.a4pic1word.R
import uz.gita.a4pic1word.databinding.ScreenGameBinding
import uz.gita.a4pic1word.mvp.contracts.GameContract
import uz.gita.a4pic1word.mvp.presenters.GamePresenter
import uz.gita.a4pic1word.utils.DurationValues
import uz.gita.a4pic1word.utils.onClick


class GameScreenWithBinding : AppCompatActivity(), GameContract.View, View.OnClickListener {

    private var _binding: ScreenGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var view: View
    private lateinit var answers: ArrayList<TextView>
    private lateinit var variants: ArrayList<TextView>
    private lateinit var presenter: GameContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
/*
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )*/
/*        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )*/

        _binding = ScreenGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadViews()
        presenter = GamePresenter(this)
        presenter.init()
    }

    private fun loadViews() {
        binding.buttonBack.onClick {
            presenter.onClickBack()
        }

        binding.answer1.setOnClickListener(this)
        binding.answer2.setOnClickListener(this)
        binding.answer3.setOnClickListener(this)
        binding.answer4.setOnClickListener(this)
        binding.answer5.setOnClickListener(this)
        binding.answer6.setOnClickListener(this)
        binding.answer7.setOnClickListener(this)
        binding.answer8.setOnClickListener(this)

        answers = ArrayList()
        answers.add(binding.answer1)
        answers.add(binding.answer2)
        answers.add(binding.answer3)
        answers.add(binding.answer4)
        answers.add(binding.answer5)
        answers.add(binding.answer6)
        answers.add(binding.answer7)
        answers.add(binding.answer8)

        variants = ArrayList()

        binding.variant1.setOnClickListener(this)
        binding.variant2.setOnClickListener(this)
        binding.variant3.setOnClickListener(this)
        binding.variant4.setOnClickListener(this)
        binding.variant5.setOnClickListener(this)
        binding.variant6.setOnClickListener(this)
        binding.variant7.setOnClickListener(this)
        binding.variant8.setOnClickListener(this)
        binding.variant9.setOnClickListener(this)
        binding.variant10.setOnClickListener(this)
        binding.variant11.setOnClickListener(this)
        binding.variant12.setOnClickListener(this)

        variants.add(binding.variant1)
        variants.add(binding.variant2)
        variants.add(binding.variant3)
        variants.add(binding.variant4)
        variants.add(binding.variant5)
        variants.add(binding.variant6)
        variants.add(binding.variant7)
        variants.add(binding.variant8)
        variants.add(binding.variant9)
        variants.add(binding.variant10)
        variants.add(binding.variant11)
        variants.add(binding.variant12)
    }

    override fun setCurrentQuestionPosition(position: Int) {
        binding.textLevel.text = position.toString()
    }

    override fun setCurrentCoinsValue(coins: Int) {
        binding.currentCoins.text = coins.toString()
    }

    override fun setImagesByPosition(images: List<Int>) {
        binding.image1.setImageResource(images[0])
        binding.image2.setImageResource(images[1])
        binding.image3.setImageResource(images[2])
        binding.image4.setImageResource(images[3])
    }

    override fun setVariantsByPosition(variant: List<Char>) {
        for (i in variant.indices) {
            variants[i].text = variant[i].toString()
        }
    }

    override fun setCurrentAnswerLength(length: Int) {
        for (i in 0 until length) {
            answers[i].visibility = View.VISIBLE
        }
        for (i in length until answers.size) {
            answers[i].visibility = View.GONE
        }
    }

    override fun clearAnswersAndVariants() {
        for (i in 0 until answers.size) {
            answers[i].text = ""
            answers[i].isEnabled = false
        }
        for (i in 0 until variants.size) {
            variants[i].isEnabled = true
        }
    }

    override fun disableAnswerButtonByPosition(position: Int) {
        answers[position].isEnabled = false
        answers[position].text = ""
    }

    override fun disableVariantButtonByPosition(position: Int) {
        variants[position].isEnabled = false
        variants[position].text = ""
    }

    override fun setLetterToAnswerButtonByPosition(position: Int, letter: Char) {
        answers[position].isEnabled = true
        answers[position].text = letter.toString()
    }

    override fun setLetterToVariantButtonByPosition(position: Int, letter: Char) {
        variants[position].isEnabled = true
        variants[position].text = letter.toString()
    }

    override fun playAnimButtonAnswer(position: Int) {
        YoYo.with(Techniques.Pulse).duration(DurationValues.BUTTONS_DURATION.duration)
            .playOn(answers[position])
    }

    override fun playAnimButtonVariant(position: Int) {
        YoYo.with(Techniques.Pulse).duration(DurationValues.BUTTONS_DURATION.duration)
            .playOn(variants[position])
    }

    override fun playAnimWrongAnswer() {
        YoYo.with(Techniques.Bounce).duration(DurationValues.WRONG_ANSWER_DURATION.duration)
            .playOn(binding.containerAnswers)
        YoYo.with(Techniques.Bounce).duration(DurationValues.WRONG_ANSWER_DURATION.duration)
            .playOn(binding.backgroundGlow)
    }

    override fun correctAnswer() {

        view = LayoutInflater.from(this).inflate(R.layout.dialog_achievement_congrat, null, false)
        val dialog = AlertDialog.Builder(this,R.style.WrapContentDialog)
            .setCancelable(false)
            .setView(view)
            .create()
        val next = view.findViewById<MaterialRippleLayout>(R.id.bt_action)
        next.setOnClickListener {
            presenter.loadData()
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onClickBackButton() {
        super.onBackPressed()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            answers[0].id -> {
                presenter.clickedAnswerButton(0)
            }
            answers[1].id -> {
                presenter.clickedAnswerButton(1)
            }
            answers[2].id -> {
                presenter.clickedAnswerButton(2)
            }
            answers[3].id -> {
                presenter.clickedAnswerButton(3)
            }
            answers[4].id -> {
                presenter.clickedAnswerButton(4)
            }
            answers[5].id -> {
                presenter.clickedAnswerButton(5)
            }
            answers[6].id -> {
                presenter.clickedAnswerButton(6)
            }
            answers[7].id -> {
                presenter.clickedAnswerButton(7)
            }
            variants[0].id -> {
                presenter.clickedVariantButton(0)
            }
            variants[1].id -> {
                presenter.clickedVariantButton(1)
            }
            variants[2].id -> {
                presenter.clickedVariantButton(2)
            }
            variants[3].id -> {
                presenter.clickedVariantButton(3)
            }
            variants[4].id -> {
                presenter.clickedVariantButton(4)
            }
            variants[5].id -> {
                presenter.clickedVariantButton(5)
            }
            variants[6].id -> {
                presenter.clickedVariantButton(6)
            }
            variants[7].id -> {
                presenter.clickedVariantButton(7)
            }
            variants[7].id -> {
                presenter.clickedVariantButton(7)
            }
            variants[8].id -> {
                presenter.clickedVariantButton(8)
            }
            variants[9].id -> {
                presenter.clickedVariantButton(9)
            }
            variants[10].id -> {
                presenter.clickedVariantButton(10)
            }
            variants[11].id -> {
                presenter.clickedVariantButton(11)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
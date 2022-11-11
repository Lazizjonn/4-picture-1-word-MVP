package uz.gita.a4pic1word.mvp.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.balysv.materialripple.MaterialRippleLayout
import uz.gita.a4pic1word.R
import uz.gita.a4pic1word.mvp.contracts.MainContract
import uz.gita.a4pic1word.mvp.presenters.MainPresenter
import uz.gita.a4pic1word.utils.onClick


class MainScreen : AppCompatActivity(), MainContract.View {

    private lateinit var settingsButton: AppCompatButton
    private lateinit var startButton: AppCompatButton
    private lateinit var textCoins: TextView
    private lateinit var textPosition: TextView
    private lateinit var image1: AppCompatImageView
    private lateinit var image2: AppCompatImageView
    private lateinit var image3: AppCompatImageView
    private lateinit var image4: AppCompatImageView
    private lateinit var rate: MaterialRippleLayout
    private lateinit var contact: MaterialRippleLayout
    private lateinit var share: MaterialRippleLayout

    private var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

/*        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )*/
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.screen_main)
        initViews()
    }

    private fun initViews() {
        settingsButton = findViewById(R.id.button_settings)
        settingsButton.onClick {
            presenter?.onClickSettings()
        }

        startButton = findViewById(R.id.button_start)
        startButton.onClick { presenter?.onClickStart() }

        rate = findViewById(R.id.rate_us)
        rate.onClick { presenter?.onClickRate() }

        contact = findViewById(R.id.contact_us)
        contact.onClick { presenter?.onClickContact() }

        share = findViewById(R.id.share)
        share.onClick { presenter?.onClickShare() }




        textCoins = findViewById(R.id.current_coins)
        textPosition = findViewById(R.id.text_position)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
    }

    override fun onStart() {
        super.onStart()
        presenter = MainPresenter(this)
        presenter?.init()
    }

    override fun navigateToGamScreen() {
        val intent = Intent(this@MainScreen, GameScreenWithBinding::class.java)
        startActivity(intent)
    }

    override fun navigateToSettingsScreen() {
        val intent = Intent(this@MainScreen, SettingsScreen::class.java)
        startActivity(intent)
    }

    override fun setCurrentQuestionPosition(position: Int) {
        textPosition.text = position.toString()
    }

    override fun setImages(images: List<Int>) {
        image1.setImageResource(images[0])
        image2.setImageResource(images[1])
        image3.setImageResource(images[2])
        image4.setImageResource(images[3])
    }

    override fun setCurrentCoins(coins: Int) {
        textCoins.text = coins.toString()
    }

    override fun onPause() {
        super.onPause()
        presenter = null
    }

    override fun rateApp() {
        val packageName =
            "details?id=uz.gita.a4pic1word" // "details?id=uz.gita.wooden15puzzleapp"  https://play.google.com/store/apps/details?id=uz.gita.a4pic1word
        val uri: Uri = Uri.parse("market://$packageName")
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {
            startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/$packageName")
                )
            )
        }
    }

    override fun shareApp(): Boolean {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val packageName = "developer?id=uz.gita.a4pic1word"
        val shareBody = "http://play.google.com/store/apps/$packageName"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Our Apps")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        ContextCompat.startActivity(this, Intent.createChooser(sharingIntent, "Share via"), null)
        return true
    }

    override fun contactUs(): Boolean {
        val email = "suyunovlaziz1997@gmail.com"
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf(email))
//        intent.type = "message/rfc822" // for multiple app
        intent.data = Uri.parse("mailto:")
        ContextCompat.startActivity(this, intent, null)
        return true
    }
}
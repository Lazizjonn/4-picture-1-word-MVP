package uz.gita.a4pic1word.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast


fun View.onClick(onClick: (View) -> Unit) {
    setOnClickListener {
        it?.let { onClick(it) }
    }
}

fun Activity.makeToast(context: Context, message:String, duration:Int){
    Toast.makeText(context, message, duration).show()
}
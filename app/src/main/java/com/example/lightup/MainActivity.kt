package com.example.lightup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
const val KeyImage = "Image"
class MainActivity : AppCompatActivity() {
    var state = R.drawable.ic_lock_black_24dp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.locked)
        savedInstanceState?.let{
            state= it.getInt(KeyImage)
            imageView.setImageDrawable(getDrawable(state))

        }
        imageView.setOnLongClickListener {
            state = when (state) {
                R.drawable.ic_lock_black_24dp -> R.drawable.ic_favorite_border_black_24dp
                R.drawable.ic_favorite_border_black_24dp -> R.drawable.ic_lock_black_24dp
                else -> R.drawable.ic_lock_black_24dp
            }

            imageView.setImageDrawable(getDrawable(state))
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KeyImage, state)
    }
}
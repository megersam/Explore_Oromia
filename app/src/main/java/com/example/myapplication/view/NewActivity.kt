package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.example.myapplication.R
import com.example.myapplication.SettingsActivity
import com.example.myapplication.uitel.getProgressiveDrawable
import com.example.myapplication.uitel.loadImage
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                //.replace(R.id.cd, NewActivity::class.java)
                .commit()
        }

        val PlaceIntent = intent
        val PlaceName = PlaceIntent.getStringExtra("name")
        val PlaceImg = PlaceIntent.getStringExtra("img")
        val PlaceInfo = PlaceIntent.getStringExtra("info")

          txtname.text = PlaceName
          txtdetail.text = PlaceInfo
          pic.loadImage(PlaceImg, getProgressiveDrawable(this))
    }
}
package com.example.a24012011148_practical_6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    private lateinit var uvpceAnimation: AnimationDrawable
    private lateinit var imgLogo: ImageView
    private lateinit var twinAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgLogo = findViewById(R.id.imgLogo)
        // uvpce_animation_list is set as src in XML
        uvpceAnimation = imgLogo.drawable as AnimationDrawable

        twinAnimation = AnimationUtils.loadAnimation(this, R.anim.twinanimation)
        twinAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            uvpceAnimation.start()
            imgLogo.startAnimation(twinAnimation)
        } else {
            uvpceAnimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onAnimationRepeat(animation: Animation?) {}
    override fun onAnimationStart(animation: Animation?) {}
}
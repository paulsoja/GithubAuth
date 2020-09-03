package com.paulsoia.githubauth.presentation.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.presentation.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
        }
    }

}
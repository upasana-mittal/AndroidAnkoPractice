package com.example.upasana.android.anko.practice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.upasana.android.anko.practice.sign_in.SignInActivity
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentFor<SignInActivity>())
        finish()
    }
}

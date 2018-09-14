package com.example.upasana.android.anko.practice.sign_in

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upasana.android.anko.practice.R
import com.example.upasana.android.anko.practice.sign_in.bl.SignInBL
import org.jetbrains.anko.*

class SignInActivity : AppCompatActivity() {

    val view: SingInView = SingInView()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)
    }

    fun authorizeUser(username: String, password: String) {
        doAsync {
            val authorized = SignInBL().checkUserCredentials(AuthCredentials(username = username, password = password))
            println(authorized)
            activityUiThread {
                if (authorized) toast("Signed!!!") else view.showAccessDeniedAlertDialog()

            }
        }
    }
}


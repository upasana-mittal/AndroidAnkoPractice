package com.example.upasana.android.anko.practice.sign_in

import com.example.upasana.android.anko.practice.R
import org.jetbrains.anko.*

class SingInView : AnkoComponent<SignInActivity> {

    private lateinit var ankoContext: AnkoContext<SignInActivity>

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui)
    {
        ankoContext = ui
        verticalLayout {
            lparams(width  = matchParent, height = matchParent)
            val username = editText {
                id = R.id.usernameEditText
                hintResource = R.string.sign_in_username
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            val password = editText {
                id = R.id.passwordEditText
                hintResource = R.string.signIn_password
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            button {
                id = R.id.signIn_button
                textResource = R.string.signIn_button
                onClick {
                    handleOnSignInButtonPressed(
                            ui = ui,
                            username = username.text.toString(),
                            password = password.text.toString())
                }
                }
            }
//                .lparams(width = matchParent, height = wrapContent)
        }
    fun showAccessDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.sigIn_alert_access_denied_title,
                    message = R.string.sigIn_alert_access_denied_msg) {

                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    }
    }



private fun handleOnSignInButtonPressed(ui: AnkoContext<SignInActivity>, username: String, password: String) {
    if (username.isBlank() or password.isBlank()) {
        with(ui) {
            alert(title = R.string.sigIn_alert_invalid_user_title,
                    message = R.string.sigIn_alert_invalid_user_message) {
                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    } else {
        ui.owner.authorizeUser(username, password)
    }
}


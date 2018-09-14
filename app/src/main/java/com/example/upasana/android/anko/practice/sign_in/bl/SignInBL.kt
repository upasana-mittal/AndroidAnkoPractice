package com.example.upasana.android.anko.practice.sign_in.bl

import com.example.upasana.android.anko.practice.sign_in.AuthCredentials

class SignInBL : ISignInBL {

    override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
        return ("frosty".equals(credentials.username) && "snowman".equals(credentials.password))
    }
}
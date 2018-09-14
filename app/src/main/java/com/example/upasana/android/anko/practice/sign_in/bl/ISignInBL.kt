package com.example.upasana.android.anko.practice.sign_in.bl

import com.example.upasana.android.anko.practice.sign_in.AuthCredentials

interface ISignInBL {

    fun checkUserCredentials(credentials: AuthCredentials): Boolean

}
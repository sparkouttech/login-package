package com.sparkout.login_register_kotlin.callback

import com.sparkout.login_register_kotlin.model.LoginDataModel
import java.io.Serializable

interface LoginDataCallback:Serializable {
    fun userData(loginDataModel: LoginDataModel)
}
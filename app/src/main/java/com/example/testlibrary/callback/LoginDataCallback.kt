package com.example.testlibrary.callback

import com.example.testlibrary.model.LoginDataModel
import java.io.Serializable

interface LoginDataCallback:Serializable {
    fun userData(loginDataModel: LoginDataModel)
}
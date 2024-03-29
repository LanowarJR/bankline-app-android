package com.example.bankline.data

import android.util.Log
import androidx.lifecycle.liveData
import com.example.bankline.data.remote.BanklineAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BanklineRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanklineAPI::class.java) }

    fun findBankStatement(accountHolderID: Int) = liveData {

        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findBankStatement(accountHolderID)))
        }catch (e: Exception){
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}
package com.example.bankline.data.remote

import com.example.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BanklineAPI {

    @GET("movimentacoes/{id}")
    suspend fun findBankStatement(@Path("id") accountHolderID: Int): List<Movimentacao>

}
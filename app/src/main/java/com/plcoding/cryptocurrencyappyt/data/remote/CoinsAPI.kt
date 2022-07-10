package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface CoinsAPI {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDTO
}
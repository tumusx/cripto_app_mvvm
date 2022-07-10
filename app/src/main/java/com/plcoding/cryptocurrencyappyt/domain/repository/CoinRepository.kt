package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

interface CoinRepository {

    suspend fun  getCoins() : List<CoinDTO>

    suspend fun  getCoinById(coinId: String): CoinDetailDTO

}
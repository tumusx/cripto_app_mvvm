package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.data.remote.CoinsAPI
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinsAPI
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }

}
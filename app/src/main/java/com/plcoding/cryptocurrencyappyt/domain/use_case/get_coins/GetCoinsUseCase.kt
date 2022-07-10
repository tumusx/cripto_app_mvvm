package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import java.net.HttpRetryException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (exception: HttpRetryException){
            emit(Resource.Error<List<Coin>>(exception.localizedMessage?: "ERROR"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "ERROR"))
        }

    }
}
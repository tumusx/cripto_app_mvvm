package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants.BASE_URL
import com.plcoding.cryptocurrencyappyt.data.remote.CoinsAPI
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton

    fun provideAPI(): CoinsAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(CoinsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinsAPI) : CoinRepository{
        return CoinRepositoryImpl(api)
    }
}
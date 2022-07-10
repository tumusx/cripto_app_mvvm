package com.plcoding.cryptocurrencyappyt.presentation

sealed class Screen(val routeScreen: String) {
    object CoinListScreen : Screen("coin_list")
    object CoinDetailScreen : Screen("coin_detail_screen")
}
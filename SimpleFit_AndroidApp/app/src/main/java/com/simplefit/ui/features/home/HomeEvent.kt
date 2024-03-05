package com.simplefit.ui.features.home

sealed interface HomeEvent {
    data class OnClickDailyCheck(val dia : String) : HomeEvent
    data class onNavigateToScreen(val index : Int) : HomeEvent
}
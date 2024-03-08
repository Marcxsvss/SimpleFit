package com.simplefit.ui.features.mainApp.routines

sealed interface RoutinesEvent {
    data object onCreateNewRoutine: RoutinesEvent
}
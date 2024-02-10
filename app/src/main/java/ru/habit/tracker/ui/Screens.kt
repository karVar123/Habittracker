package ru.habit.tracker.ui

enum class Screens(val route: String) {
    LOGIN("LOGIN"),
    REGISTRATION("REGISTRATION"),
    RECOVERY("RECOVERY"), MAIN("MAIN"),
    NEW_PASSWORD_SCREEN("NEW_PASSWORD_SCREEN"),
    CONFIRMATION_SCREEN("CONFIRMATION_SCREEN"),


}

enum class MenuScreens(val route: String) {
    HOME_SCREEN("HOME_SCREEN"),
    CALENDAR_SCREEN("CALENDAR_SCREEN"),
    ADD_NEW_HABIT("ADD_NEW_HABIT"),
    LUMP_SCREEN("LUMP_SCREEN"),
    SETTINGS_SCREEN("SETTINGS_SCREEN"),

}

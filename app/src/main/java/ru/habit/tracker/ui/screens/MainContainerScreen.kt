package ru.habit.tracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.habit.tracker.MenuScreens
import ru.habit.tracker.ui.BottomActionBar
import ru.habit.tracker.ui.screens.menu.AddNewHabitScreen
import ru.habit.tracker.ui.screens.menu.CalendarScreen
import ru.habit.tracker.ui.screens.menu.HomeScreen
import ru.habit.tracker.ui.screens.menu.LampScreen
import ru.habit.tracker.ui.screens.menu.SettingsScreen


@Preview
@Composable
fun MainContainerScreenPREV() {
    MainContainerScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainerScreen() {
    val menuNavController = rememberNavController()


    Scaffold(containerColor = Color(0xFFF8F8F8), bottomBar = {
        BottomActionBar(menuNavController)
    }) {

        Surface(
            color = Color(0xFFF8F8F8), modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp)
        ) {
            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = menuNavController,
                startDestination = MenuScreens.HOME_SCREEN.route
            ) {
                composable(MenuScreens.HOME_SCREEN.route) { HomeScreen() }
                composable(MenuScreens.CALENDAR_SCREEN.route) { (CalendarScreen()) }
                composable(MenuScreens.ADD_NEW_HABIT.route) { AddNewHabitScreen(menuNavController) }
                composable(MenuScreens.LUMP_SCREEN.route) { (LampScreen()) }
                composable(MenuScreens.SETTINGS_SCREEN.route) { SettingsScreen() }
            }
        }

        it
    }
}



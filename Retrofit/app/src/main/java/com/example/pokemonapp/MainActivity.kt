package com.example.pokemonapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.pokemonapp.data.Home
import com.example.pokemonapp.data.MainTab
import com.example.pokemonapp.data.Profile
import com.example.pokemonapp.data.Search
import com.example.pokemonapp.presentation.HomePage
import com.example.pokemonapp.presentation.ProfilePage
import com.example.pokemonapp.presentation.SearchPage
import com.example.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonAppTheme {
                PokemonAppMain()
            }
        }
    }
}

@Composable
fun PokemonAppMain() {

    var selectedTab by rememberSaveable {
        mutableStateOf(MainTab.HOME)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == MainTab.HOME,
                    onClick = { selectedTab = MainTab.HOME },
                    icon = { Icon (
                        painterResource(R.drawable.ic_action_name),
                        contentDescription = null) },
                    label = { Text(text = "Home") }
                )

                NavigationBarItem(
                    selected = selectedTab == MainTab.SEARCH,
                    onClick = { selectedTab = MainTab.SEARCH },
                    icon = { Icon (
                        painterResource(R.drawable.outline_category_search_24),
                        contentDescription = null) },
                    label = { Text(text = "Search") }
                )

                NavigationBarItem(
                    selected = selectedTab == MainTab.PROFILE,
                    onClick = { selectedTab = MainTab.PROFILE },
                    icon = { Icon (
                        painterResource(R.drawable.ic_action_name),
                        contentDescription = null) },
                    label = { Text(text = "Profile") }
                )
            }
        }
    ) { padding ->

        // Un backstack PAR onglet ->
// chacun garde sa propre sous-navigation
        val homeBackStack =
            rememberNavBackStack(Home)
        val searchBackStack =
            rememberNavBackStack(Search)
        val profileBackStack =
            rememberNavBackStack(Profile)

        Box(modifier = Modifier.padding(padding)) {
            when(selectedTab) {
                MainTab.HOME -> NavDisplay(
                    backStack = homeBackStack,
                    entryProvider = entryProvider {
                        entry<Home> { HomePage() }
                    }
                )
                MainTab.SEARCH -> NavDisplay(
                    backStack = searchBackStack,
                    entryProvider = entryProvider {
                        entry<Search> { SearchPage() }
                    }
                )
                MainTab.PROFILE -> NavDisplay(
                    backStack = profileBackStack,
                    entryProvider = entryProvider {
                        entry<Profile> { ProfilePage() }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonAppTheme {
        Greeting("Android")
    }
}
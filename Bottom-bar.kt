package com.example.navigointi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomBarnav()
{
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Navigointi",
                    color = Color.Black,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
            },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors  (
                containerColor = Color.Blue,
                titleContentColor = Color.Black
            ),
            )
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        },
        content = {innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding))
            {
                NavHost(navController = navController, startDestination = "Home")
                {
                    composable("Home"){ Home(navController)}
                    composable("Profile"){ Profile(navController) }
                }
            }
        }
    )
}
@Composable
fun BottomBarNavigation(navController : NavHostController)
{
    NavigationBar {
        NavigationBarItem(
            icon = {Icon(Icons.Default.Home,contentDescription = "Home")},
            label = { Text("Home")},
            selected = false,
            onClick = {navController.navigate("Home")}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile")},
            label = {Text("Profile")},
            selected = false,
            onClick = {navController.navigate("Profile")}
        )
    }
}
@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Home",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
    }
}
@Composable
fun Profile(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Profile",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().
            wrapContentSize(Alignment.Center)
        )
    }
}


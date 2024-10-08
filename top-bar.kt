package com.example.navigointi
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigointi.ui.theme.NavigointiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Nabtehtava() {
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
                colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors  (
                    containerColor = Color.Blue,
                    titleContentColor = Color.Black
                )
            )
        },
        content =
        { innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding)) {
                NavHost(navController = navController, startDestination = "HomeScreen") {
                    composable("HomeScreen"){ HomeScreen(navController)}
                    composable("DetailsScreen"){ DetailsScreen(navController)}
                    composable("SettingsScreen"){ SettingsScreen(navController)}

                }
            }
        }
    )
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Home",
        fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center))
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick={
            navController.navigate("DetailsScreen")},
            modifier = Modifier.padding(10.dp).
            align(Alignment.CenterHorizontally))
        {
            Text("Details")
        }

    }
}
@Composable
fun DetailsScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Details",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().
            wrapContentSize(Alignment.Center))
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick={navController.navigate("SettingsScreen")},
            modifier = Modifier.padding(10.dp).
            align(Alignment.CenterHorizontally))
        {
            Text("Settings")
        }
    }
}
@Composable
fun SettingsScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Settings",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().
            wrapContentSize(Alignment.Center))
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick={navController.navigate("HomeScreen")},
            modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
        {
            Text("Home")
        }
    }
}

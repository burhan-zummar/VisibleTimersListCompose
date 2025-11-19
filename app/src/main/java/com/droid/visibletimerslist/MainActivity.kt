package com.droid.visibletimerslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droid.visibletimerslist.ui.theme.VisibleTimersListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisibleTimersListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VisibleTimersScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun VisibleTimersScreen(modifier: Modifier = Modifier) {

    val viewModel = viewModel<VisibleTimerViewModel>()
    val countDown = viewModel.countDownFlow.collectAsState(60)
    LazyColumn {
        items(100) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Item ${it + 1}",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = "${countDown.value}",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VisibleTimersPreview() {
    VisibleTimersListTheme {
        VisibleTimersScreen()
    }
}
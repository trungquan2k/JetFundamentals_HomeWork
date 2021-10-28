package com.example.jetfundamentals.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetfundamentals.R
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun SurfaceScreen(modifier: Modifier = Modifier) {

  Box(modifier = modifier.fillMaxSize()) {
    MySurface(modifier = modifier.align(Alignment.Center))
  }

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MySurface(modifier: Modifier) {
  Surface(
    modifier = Modifier.padding(6.dp),
    border = BorderStroke(2.dp, Color.Red),
    contentColor = Color.Blue,
    elevation = 6.dp,
    shape = CircleShape
  ) {
    val image: Painter = painterResource(id = R.drawable.logo)
    Image(painter = image, contentDescription = "",modifier=Modifier.height(100.dp).width(100.dp))
//    Text("Hello World", modifier = Modifier.padding(8.dp))
  }
}
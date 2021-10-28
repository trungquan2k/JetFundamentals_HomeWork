package com.example.jetfundamentals.screens

import androidx.compose.runtime.Composable
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun ColumnScreen() {
  MyColumn()

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MyColumn() {
  //TODO write your code here
}
package com.example.jetfundamentals.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.KeyboardType
import com.example.jetfundamentals.R

import androidx.compose.ui.unit.dp

import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun TextFieldScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        EmailTextField()
        TextFieldPassword()
        SavePassword()
        ButtonLogin()
    }

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}


@Composable
fun SizeBox(){
    Spacer(modifier = Modifier.height(30.dp))
}
@Composable
fun Logo(){
   Column(modifier = Modifier.height(100.dp).width(100.dp)) {
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
}


@Composable
fun EmailTextField() {
    val textValue = remember { mutableStateOf("") }
    val primaryColor = colorResource(id = R.color.colorPrimary)

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        )
    )
}

@Composable
fun TextFieldPassword() {
    val textValue = remember { mutableStateOf("") }
    val primaryColor = colorResource(id = R.color.colorPrimary)

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        )
    )
}

@Composable
fun ButtonLogin() {
    Button(
        modifier = Modifier.padding(all = 8.dp),
        onClick = {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = colorResource(id = R.color.colorPrimary)
        )
    )
    {
        Text(text = "Login")
    }
}

@Composable
fun SavePassword() {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
        )
        Text(text = "Save password")
    }
}

//@Composable
//fun UserInfoScreen(userInfo: UserInfo) {
//    Column(modifier = Spacing(8.dp)) {
//        Text(
//            text = "Username: ${userInfo.userName}",
//            modifier = Spacing(8.dp),
//            style = (+MaterialTheme.typography()).h6
//        )
//
//    }
//}
//@Composable
//fun LoginScreen(userInfo: UserInfo = UserInfo()) {
//    Column {
//        val userNameState = +state { "" }
//        Text(
//            text = "Username:",
//            modifier = Spacing(8.dp),
//            style = (+MaterialTheme.typography()).h4
//        )
//        Surface(border = Border(Color.Gray, 1.dp), modifier = Spacing(8.dp)) {
//            Padding(8.dp) {
//                TextField(
//                    value = userNameState.value,
//                    onValueChange = { userNameState.value = it }
//                )
//
//            }
//        }
//
//        val passwordState = +state { "" }
//        Text(
//            text = "Password:",
//            modifier = Spacing(8.dp),
//            style = (+MaterialTheme.typography()).h4
//        )
//        Surface(border = Border(Color.Gray, 1.dp), modifier = Spacing(8.dp)) {
//            Padding(padding = 8.dp) {
//                PasswordTextField(
//                    value = passwordState.value,
//                    onValueChange = { passwordState.value = it }
//                )
//            }
//        }
//
//        if (userNameState.value.isNotEmpty()
//            && passwordState.value.isNotEmpty()
//        ) {
//            Row(arrangement = Arrangement.End) {
//                Button(
//                    text = "Login",
//                    modifier = Spacing(8.dp),
//                    onClick = {
//                        println("Logged in!")
//                        userInfo.userName = userNameState.value
//                        userInfo.userLoggedIn = true
//                    }
//                )
//            }
//        } else {
//            Text(
//                text = "Please enter both username and password!",
//                modifier = Spacing(8.dp),
//                style = (+MaterialTheme.typography()).h6
//            )
//        }
//    }
//}
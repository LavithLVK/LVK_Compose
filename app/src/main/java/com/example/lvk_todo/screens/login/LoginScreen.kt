package com.example.lvk_todo.screens.login

import android.icu.number.Scale
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.lvk_todo.R
import com.example.lvk_todo.ui.theme.LVKTextFieldColors
import com.example.lvk_todo.ui.theme.Pink40
import com.example.lvk_todo.ui.theme.Pink80
import com.example.lvk_todo.ui.theme.Purple40
import com.example.lvk_todo.ui.theme.Purple80

@Composable
fun LoginScreen() {

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                color = Color.White
            ), contentAlignment = Alignment.TopCenter
    ) {

        Canvas(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            scale(scaleX = -10f, scaleY = -15f) {
                drawCircle(Pink40, radius = 20.dp.toPx())
            }
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            scale(scaleX = 15f, scaleY = 10f) {
                drawCircle(Pink40, radius = 15.dp.toPx())
            }
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            scale(scaleX = -10f, scaleY = 12f) {
                drawCircle(Pink40, radius = 15.dp.toPx())
            }
        }

        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(.65f)
                .padding(start = 20.dp, end = 20.dp, top = 100.dp),
            shape = RoundedCornerShape(
                topStart = 10.dp, topEnd = 10.dp, bottomStart = 200.dp, bottomEnd = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = username.value,
                    onValueChange = {
                        if (it.length <= 25) {
                            username.value = it
                        }
                    },
                    isError = username.value.length == 3,
                    colors = LVKTextFieldColors,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    label = {
                        Text(
                            text = "Username", style = MaterialTheme.typography.labelSmall
                        )
                    },
                    modifier = Modifier
                        .padding(
                            start = 15.dp, end = 15.dp, top = 20.dp, bottom = 10.dp
                        )
                        .fillMaxWidth(1f),
                    maxLines = 2,
                    shape = RoundedCornerShape(
                        topStart = 10.dp, topEnd = 30.dp, bottomEnd = 30.dp, bottomStart = 10.dp
                    )
                )
                TextField(
                    value = password.value,
                    onValueChange = { if (it.length <= 20) password.value = it },
                    isError = password.value.length == 3,
                    colors = LVKTextFieldColors,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    label = {
                        Text(
                            text = "Password", style = MaterialTheme.typography.labelSmall
                        )
                    },
                    shape = RoundedCornerShape(
                        topStart = 10.dp, topEnd = 30.dp, bottomEnd = 30.dp, bottomStart = 10.dp
                    ),
                    modifier = Modifier
                        .padding(
                            start = 15.dp, end = 15.dp, top = 10.dp, bottom = 20.dp
                        )
                        .fillMaxWidth(1f),
                    maxLines = 1,

                    )
                Text(
                    text = "Forgot Password?",
                    color = Color.Gray,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 20.dp, top = 10.dp)
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 15.dp, top = 30.dp)
                        .fillMaxWidth(.5f),
                    colors = ButtonDefaults.buttonColors(containerColor = Pink40),
                    shape = RoundedCornerShape(30.dp),
                ) {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_google_plus),
                    contentDescription = "G-sign in",
                    modifier = Modifier.align(
                        Alignment.Start
                    ).padding(start = 40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_fb),
                    contentDescription = "G-sign in",
                    modifier = Modifier.align(
                        Alignment.Start
                    ).padding(start = 80.dp, top = 10.dp)
                )
            }
        }
    }

}
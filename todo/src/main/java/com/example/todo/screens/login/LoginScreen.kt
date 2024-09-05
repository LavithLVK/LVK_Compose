package com.example.todo.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.ui.theme.LVKTextFieldColors
import com.example.todo.ui.theme.Pink40
import com.example.todo.ui.theme.Pink60

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
                .fillMaxHeight(.85f)
                .padding(start = 20.dp, end = 20.dp, top = 100.dp),
            shape = CutCornerShape(
                topStartPercent = 5,
                topEndPercent = 5,
                bottomStartPercent = 95,
                bottomEndPercent = 5
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "LOGO",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Light,
                    color = Pink40,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = username.value,
                    onValueChange = {
                        if (it.length <= 25) {
                            username.value = it
                        }
                    },
                    isError = username.value.length == 3,
                    colors = LVKTextFieldColors,
                    textStyle = MaterialTheme.typography.titleMedium,
                    label = {
                        Text(
                            text = "Username", style = MaterialTheme.typography.labelSmall
                        )
                    },
                    modifier = Modifier
                        .padding(
                            start = 15.dp, end = 15.dp
                        )
                        .fillMaxWidth(1f),
                    maxLines = 2,
                    shape = RoundedCornerShape(
                        topStart = 10.dp, topEnd = 30.dp, bottomEnd = 30.dp, bottomStart = 10.dp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = password.value,
                    onValueChange = { if (it.length <= 20) password.value = it },
                    isError = password.value.length == 3,
                    colors = LVKTextFieldColors,
                    textStyle = MaterialTheme.typography.titleMedium,
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
                        .fillMaxWidth(.5f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Pink60,
                                    Pink60, Pink60
                                )
                            )
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
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
                    modifier = Modifier
                        .align(
                            Alignment.Start
                        )
                        .padding(start = 40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_fb),
                    contentDescription = "G-sign in",
                    modifier = Modifier
                        .align(
                            Alignment.Start
                        )
                        .padding(start = 80.dp, top = 10.dp)
                )
            }
        }
    }

}
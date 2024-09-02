package com.example.lvk_todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            val listScreen = ListScreen()

            LazyColumn(content = {
                items(listScreen.getProfiles()) { item ->
                    listScreen.Profile(
                        profileImage = item.img,
                        name = item.name,
                        position = item.position,
                        modifier = Modifier
                    )
                }
            })

        }
    }

}

//@Preview(showBackground = true)
@Composable
fun TextInput(label: String = "label") {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(text = label, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Light)
        }
    )
}

@Composable
fun ShowExample() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInput("usrnm")
        TextInput("pswrd")
    }
}

//@Composable
//fun Profile(profileImage: Int, name: String, position: String, modifier: Modifier) {
//    Card(
//        elevation = CardDefaults.cardElevation(10.dp),
//        shape = RoundedCornerShape(10.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.LightGray
//        ),
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(top = 0.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
//    ) {
//        Row(modifier = Modifier.padding(10.dp)) {
//            Image(
//                painter = painterResource(id = profileImage),
//                contentDescription = "profile dummy",
//                Modifier
//                    .border(width = 2.dp, Color.Black, CircleShape)
//                    .padding(10.dp)
//                    .align(Alignment.CenterVertically),
//                contentScale = ContentScale.Fit
//            )
//            Column(
//                modifier = Modifier
//                    .padding(horizontal = 15.dp, vertical = 10.dp)
//            ) {
//                Text(text = name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
//                Text(text = position, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Normal)
//            }
//        }
//    }
//
//
//}



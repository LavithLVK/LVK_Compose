package com.example.lvk_todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class ListScreen {

    @Composable
    fun Profile(profileImage: Int, name: String, position: String, modifier: Modifier) {
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
        ) {
            ProfileCard(profileImage = profileImage, name = name, position = position)
        }

    }

    @Composable
    fun ProfileCard(profileImage: Int, name: String, position: String) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = "profile dummy",
                Modifier
                    .border(width = 2.dp, Color.Black, CircleShape)
                    .padding(10.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = position,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }


    data class UserProfile(val img: Int, val name: String, val position: String)

    fun getProfiles(): MutableList<UserProfile> {
        val profiles = mutableListOf<UserProfile>()

        for (i in 1..15) {
            profiles.add(
                UserProfile(
                    img = R.drawable.profile,
                    name = "Lavith Edam $i",
                    position = "Principle Software Engineer"
                )
            )
        }

        return profiles
    }
}
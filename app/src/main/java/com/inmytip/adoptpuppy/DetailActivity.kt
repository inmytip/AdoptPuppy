package com.inmytip.adoptpuppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inmytip.adoptpuppy.data.Datasource
import com.inmytip.adoptpuppy.model.Puppy
import com.inmytip.adoptpuppy.ui.theme.AdoptPuppyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptPuppyTheme {
                val id = intent.getIntExtra("id", 0)
                PuppyDetail(id = id)
            }
        }
    }
}

@Composable
fun PuppyDetail(id: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Puppy Detail")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Outlined.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ){ ScreenContent(id, Datasource().loadPuppies()) }
}

@Composable
fun ScreenContent(id: Int, puppy: List<Puppy>) {
    val resources = LocalContext.current.resources
    val gender = if (puppy[id].gender == 1) "Male" else "Female"
    val farm = when(puppy[id].farmId){
        R.string.farm1 -> "Cheeze Pomeranian Farm"
        R.string.farm2 -> "178 Farm"
        R.string.farm3 -> "Cityofdogs Farm"
        else -> "Poodle Toy Farm"
    }
    val about = when(puppy[id].farmId){
        R.string.farm1 -> resources.getString(R.string.about1)
        R.string.farm2 -> resources.getString(R.string.about2)
        R.string.farm3 -> resources.getString(R.string.about3)
        else -> resources.getString(R.string.about4)
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp)
    ) {
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
        ) {
            Surface(
                //modifier = Modifier.size(80.dp),
                shape = RoundedCornerShape(16.dp),
                //color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(
                    painter = painterResource(puppy[id].imageId),
                    contentDescription = null
                    // Modifier.border(color = Color.LightGray, width = 8.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(32.dp))
        LazyColumn {

            item {
                Text(text = "Breed",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp))
            }
            item {
                Text(text = resources.getString(puppy[id].breedId),
                    color = Color(0xff808080),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp))
            }
            item {
                Text(text = "Gender",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp))
            }
            item {
                Text(text = gender,
                    color = Color(0xff808080),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp))
            }
            item {
                Text(text = "Farm",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp))
            }
            item {
                Text(text = farm,
                    color = Color(0xff808080),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp))
            }
            item {
                Text(text = "Facebook",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp))
            }
            item {
                Text(text = "@${resources.getString(puppy[id].farmId)}",
                    color = Color(0xff808080),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp))
            }
            item {
                Text(text = "About",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp))
            }
            item {
                Text(text = about,
                    color = Color(0xff808080),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp))
            }
        }

    }
}

@Preview()
@Composable
fun PuppyDetail() {
    AdoptPuppyTheme {
        PuppyDetail()
    }
}
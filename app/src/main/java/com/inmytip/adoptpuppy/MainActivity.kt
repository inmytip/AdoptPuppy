package com.inmytip.adoptpuppy

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.inmytip.adoptpuppy.data.Datasource
import com.inmytip.adoptpuppy.model.Puppy
import com.inmytip.adoptpuppy.ui.theme.AdoptPuppyTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Female
import androidx.compose.material.icons.outlined.Male
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptPuppyTheme {
                AdoptPuppy()
            }
        }
    }
}

@Composable
fun AdoptPuppy() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt Puppy")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Outlined.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ){ ScreenContent(Datasource().loadPuppies()) }
}

@Composable
fun ScreenContent(puppies: List<Puppy>) {

    val scrollState = rememberLazyListState()
    val resources = LocalContext.current.resources

    LazyColumn(state = scrollState) {
        items(puppies) { puppies ->
            Puppies(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
                id = puppies.id,
                breed = resources.getString(puppies.breedId),
                farm = resources.getString(puppies.farmId),
                image = puppies.imageId,
                gender = puppies.gender
            )
        }
    }

}

@Composable
fun Puppies(modifier: Modifier = Modifier, id: Int, breed: String, farm: String, image: Int, gender: Int) {

    val context = LocalContext.current

    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.LightGray, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
        // backgroundColor = Color(0xFFb9f6ca)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = {
                    context.startActivity(Intent(context, DetailActivity::class.java)
                        .apply { putExtra("id", id) })
                })
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
        ) {
            Surface(
                modifier = Modifier.size(80.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null, // decorative
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .height(80.dp)
            ) {
                Text(text = breed,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "@$farm",
                    color = Color(0xffaa00ff),
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(if (gender == 1) Icons.Outlined.Male else Icons.Outlined.Female,
                contentDescription = null,
                tint = if (gender == 1) Color(0xff448aff) else Color(0xffff80ab)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdoptPuppyTheme {
        ScreenContent(Datasource().loadPuppies())
    }
}
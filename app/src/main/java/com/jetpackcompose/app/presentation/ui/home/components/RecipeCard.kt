package com.jetpackcompose.app.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.jetpackcompose.app.R
import com.jetpackcompose.domain.model.Recipe

@ExperimentalCoilApi
@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            recipe.featuredImage?.let { img ->
                //load image with coil
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(100.dp),
                    painter = rememberImagePainter(
                        data = img,
                        builder = {
                            crossfade(true)
                            placeholder(R.drawable.place_holder)
                            scale(Scale.FILL)
                        }
                    ),
                    contentDescription = "food image",
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = 8.dp,
                        end = 8.dp
                    )
            ) {
                recipe.title?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                recipe.rating?.let {
                    Text(
                        text = "comments: $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

        }
    }
}
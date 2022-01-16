package com.jetpackcompose.detailpage.presentation

import android.os.Bundle
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.jetpackcompose.detailpage.presentation.components.DetailContent
import com.jetpackcompose.resources.components.CircularProgress
import com.jetpackcompose.resources.components.SquareView

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    argument: Bundle?
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    viewModel.loading.value.let {
        expanded = !it
    }

    viewModel.error.value?.let {

    }

    ConstraintLayout(
        modifier = Modifier
            .semantics { contentDescription = "detail" }
            .fillMaxSize()
    ) {
        val (image, content) = createRefs()

        val guideline = createGuidelineFromTop(0.3f)

        SquareView(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .alpha(0.5f)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = rememberImagePainter(
                    data = viewModel.detail.value?.featuredImage,
                    builder = {
                        crossfade(true)
                        scale(Scale.FILL)
                    }
                ),
                contentDescription = "detail image",
                contentScale = ContentScale.Crop
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(content) {
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
        ) {
            AnimatedContent(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                targetState = expanded
            ) { target ->
                if (target) {
                    DetailContent(
                        title = viewModel.detail.value?.title.toString(),
                        list = viewModel.detail.value?.ingredients ?: listOf()
                    )
                } else {
                    CircularProgress(
                        Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
            }
        }
    }
}
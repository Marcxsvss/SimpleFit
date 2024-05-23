package com.simplefit.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefitAdmin.R
import com.simplefit.ui.features.mainApp.home.HomeEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListConsejos(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    consejos: List<String>
) {
    Box( //Ver entrenamiento de hoy
        Modifier
            .width(358.dp)
            .height(100.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Transparent),
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                ),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )
    )
    {
        Image(
            painter =  painterResource(id = R.drawable.consejos_background_2),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        HorizontalPager(
            modifier = modifier.fillMaxWidth().height(100.dp),
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = consejos[page],
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                    fontStyle = FontStyle.Normal
                )
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color: Color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray

            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(9.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderConsejos(
    modifier: Modifier = Modifier,
    consejos: List<String>
) {
    val pagerState: PagerState = rememberPagerState(pageCount = { consejos.size })
    val coroutineScope = rememberCoroutineScope()

    // Automatic scroll HorizontalPager
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            coroutineScope.launch {
                val nextPage: Int = if (pagerState.currentPage + 1 == pagerState.pageCount) 0 else pagerState.currentPage + 1
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth().height(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ListConsejos(
            modifier = Modifier,//.weight(0.9f),
            pagerState = pagerState,
            consejos = consejos
        )
        PagerIndicator(
            modifier = Modifier.padding(top = 10.dp),
            pagerState = pagerState
        )
    }
}
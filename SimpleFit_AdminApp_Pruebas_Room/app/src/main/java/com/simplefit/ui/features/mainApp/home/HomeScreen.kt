package com.simplefit.ui.features.mainApp.home

import android.widget.LinearLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kinoyamboladmin.ui.features.movieform.ImageSelector
import com.simplefit.ui.composables.HeaderConsejos
import com.simplefit.ui.composables.HomeButton
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefitAdmin.R
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToUsuarios: () -> Unit,
    onNavigateToRutinas: () -> Unit,
    onNavigateToConsejos: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "ADMINISTRACIÓN",
            color = Color(0xFFDAB338),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(25.dp))
        HomeButton(
            onNavigateTo = onNavigateToUsuarios,
            texto = "USUARIOS",
        )
        Spacer(modifier = Modifier.height(25.dp))
        HomeButton(
            onNavigateTo = onNavigateToRutinas,
            texto = "RUTINAS",
        )
//        Spacer(modifier = Modifier.height(25.dp))
//        HomeButton(
//            onNavigateTo = onNavigateToConsejos,
//            texto = "CONSEJOS",
//
//        )
//        Spacer(modifier = Modifier.height(25.dp))
//        HomeButton(
//            onNavigateTo = {  },
//            texto = "MAQUINAS",
//        )

    }
}

package com.example.russruletka.rr

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.russruletka.R
import com.example.russruletka.ui.theme.Number
import com.example.russruletka.ui.theme.Red

@Composable
fun RR() {
    var rotationValue by remember { mutableStateOf(0f) }
    var number by remember { mutableStateOf(0) }

    val angle by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(angle) {
        if (angle == rotationValue) {
            val index = ((360 - (angle % 360)) / (360f / Number.list.size)).toInt()
            number = Number.list.getOrNull(index) ?: 0
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
            text = number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = White
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ruletka),
                contentDescription = "рулетка",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(
                painter = painterResource(id = R.drawable.strelka),
                contentDescription = "стрелка",
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(
            onClick = {
                rotationValue = (720..1080).random().toFloat() + angle
            },
            colors = ButtonDefaults.buttonColors(containerColor = Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp)
                .padding(20.dp)
        ) {
            Text(
                text = "Крути давай",
                color = White,
            )
        }
    }
}
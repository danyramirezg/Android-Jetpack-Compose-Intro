package com.example.androidjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Use createRefs (with ´s´ at end) when have more than one variable.
        val (boxCyan, boxYellow, boxGreen, boxMagenta, boxBlue) = createRefs()

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxCyan.top)
                    start.linkTo(boxCyan.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxCyan.top)
                    end.linkTo(boxCyan.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxCyan.bottom)
                    start.linkTo(boxCyan.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxCyan.bottom)
                    end.linkTo(boxCyan.start)

                })
    }
}

@Preview
@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout() {
        val boxMagenta = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(Modifier.size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
    }
}
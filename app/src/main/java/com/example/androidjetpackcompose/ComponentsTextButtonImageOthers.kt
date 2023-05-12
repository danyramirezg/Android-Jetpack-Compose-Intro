package com.example.androidjetpackcompose

import android.util.Log
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcompose.ui.theme.AndroidJetpackComposeTheme
import com.example.androidjetpackcompose.ui.theme.CheckInfo

@Preview
@Composable
fun TextStyles() {
    Column {
        MyTextField()
        Text(
            text = "This is a line through example",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = " underline example",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "A combine example (line through and underline)",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText,
        onValueChange = {
            myText = if (it.contains(">")) {
                it.replace(">", " ?")
            } else {
                it
            }
        }, label = { Text(text = "Introduce your name") })
}

@Preview
@Composable
fun MyButton() {
    var enableButton by remember { mutableStateOf(true) }

    Button(
        onClick = { enableButton = false },
        enabled = enableButton,
        modifier = Modifier.padding(24.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Gray
        )
    ) {
        Text("Hello")
    }
}

@Preview
@Composable
fun MyTextButton() {
    TextButton(onClick = { Log.i("Text Button", "It´s similar to a button") }) {
        Text("It´s a Text Button!")
    }
}

@Preview
@Composable
fun MyCircularImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Magenta, CircleShape)
    )
}

@Preview
@Composable
fun MyIcon() {
    /*
    https://fonts.google.com/icons

    I could implement a library to get different icons:
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
     */
    Box(Modifier.padding(24.dp)) {
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = "Icon",
            tint = Color.Gray
        )
    }
}

@Preview
@Composable
fun MyProgressBar() {

    var showLoading by rememberSaveable { mutableStateOf(false) }
    var counter by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Cyan, strokeWidth = 8.dp, progress = counter)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { counter += 0.25f }) {
                    Text("Increase")
                }
                Button(onClick = { counter -= 0.25f }) {
                    Text("Decrease")
                }
            }
            LinearProgressIndicator(Modifier.padding(top = 24.dp), Color.Magenta)
            TextButton(onClick = { /*TODO*/ }) {
                Text("Loading")
            }
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Click me!")
        }
    }
}

@Preview
@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        modifier = Modifier.padding(24.dp),
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedTrackColor = Color.Cyan,
            uncheckedThumbColor = Color.Magenta
        )
    )
}

@Preview
@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = state, onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                checkmarkColor = Color.Cyan,
                uncheckedColor = Color.Gray
            )
        )
    }
}

@Preview
@Composable
fun MyTriStateCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Indeterminate) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Preview
@Composable
private fun TestScreen() {
    AndroidJetpackComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val myOptions = getOptions(titles = listOf("Data 1", "Data 2", "Data 3"))
            Column() {
                myOptions.forEach() {
                    CheckBoxWithTextCompleted(checkInfo = it)
                }
                Row(Modifier.padding(16.dp)) {
                    var selected by remember { mutableStateOf("Example")}
                    RadioButtonList(name = selected, onItemSelected = { selected = it } )
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus -> status = newStatus }
        )
    }
}

@Composable
fun RadioButtonList(name: String, onItemSelected: (String) -> Unit) {
    Column() {
        RadioButton(selected = name == "Example 1", onClick = { onItemSelected("Example 1") })
        Text(text = "Example 1")

        RadioButton(selected = name == "Example 2", onClick = { onItemSelected("Example 2") })
        Text(text = "Example 2")

        RadioButton(selected = name == "Example 3", onClick = { onItemSelected("Example 3") })
        Text(text = "Example 3")
    }
}

@Preview
@Composable
fun MyAdvanceSlider() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 32.dp)
    ) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var textSlider by remember { mutableStateOf("") }

        Slider(
            modifier = Modifier
                .background(Color(R.color.teal_200))
                .padding(vertical = 16.dp),
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { textSlider = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9 // From 0 to 10 is eleven, I should subtract 2 (11 - 2 = 9)
        )
        Text(text = textSlider)
    }
}

/* Other Components:
    - Card
    - Surface
    - BadgeBox
    - Divider
    - DropdownMenu
    - RangeSlider
 */


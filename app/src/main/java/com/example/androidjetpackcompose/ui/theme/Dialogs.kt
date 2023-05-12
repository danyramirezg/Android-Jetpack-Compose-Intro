package com.example.androidjetpackcompose.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ShowScreen() {
    AndroidJetpackComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            var showAlertDialog by remember {
                mutableStateOf(false)
            }
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = { showAlertDialog = true }) {
                    Text(text = "Show Alert Dialog")
                }
                MyAlertDialog(
                    show = showAlertDialog,
                    onConfirm = { Log.i("Accept", "Accept button") },
                    onDismiss = { showAlertDialog = false })
            }
        }
    }
}

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show)
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Title") },
            text = { Text(text = "Description Alert Dialog") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Accept")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            }
        )
}

/* Other Components:
    - Dialog
 */
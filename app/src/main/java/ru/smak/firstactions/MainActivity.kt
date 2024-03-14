package ru.smak.firstactions

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.smak.firstactions.ui.theme.FirstActionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstActionsTheme {
                MainUI(
                    Modifier
                        .fillMaxSize()
                        .padding(8.dp))
            }
        }
    }
}

@Composable
fun MainUI(modifier: Modifier = Modifier) {
    var v by remember {mutableStateOf("")}
    var v2 by remember { mutableStateOf("") }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = v,
            onValueChange = { v = it },
            modifier = Modifier.fillMaxWidth(),
            label = {Text("Введите тут что-нибудь")},
        )
        Button(
            onClick = { v2 = v },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            ),
            shape = RectangleShape
        ) {
            Text("Нажми меня")
        }
        Text(text = v2)
    }
}

@Preview
@Composable
fun MainUIPreview(){
    FirstActionsTheme {
        MainUI(
            Modifier
                .fillMaxSize()
                .padding(8.dp))
    }
}

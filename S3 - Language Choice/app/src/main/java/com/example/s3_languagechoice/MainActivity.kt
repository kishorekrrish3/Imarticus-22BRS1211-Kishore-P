package com.example.s3_languagechoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.s3_languagechoice.ui.theme.S3LanguageChoiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S3LanguageChoiceTheme {
                LanguageSelectionScreen()
            }
        }
    }
}

@Composable
fun LanguageSelectionScreen() {
    var currentLanguage by remember { mutableStateOf("en") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = getGreetingsString(currentLanguage))
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Toggle between "en" and "de"
                currentLanguage = if (currentLanguage == "en") "de" else "en"
            }) {
                Text(text = getButtonText(currentLanguage))
            }
        }
    }
}

@Composable
fun getGreetingsString(language: String): String {
    return when (language) {
        "en" -> stringResource(id = R.string.hello_world)
        "de" -> LocalContext.current.resources.getString(R.string.hello_world) // For German
        else -> ""
    }
}

@Composable
fun getButtonText(language: String): String {
    return when (language) {
        "en" -> "Switch to German"
        "de" -> "Switch to English"
        else -> ""
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLanguageSelectionScreen() {
    S3LanguageChoiceTheme {
        LanguageSelectionScreen()
    }
}

package com.example.dsa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.dsa.binarysearch.BinarySearch
import com.example.dsa.ui.theme.DSATheme
import androidx.compose.material3.Button


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DSATheme {
                var resultText by remember { mutableStateOf("Result will appear here") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NumberInputExample(
                        modifier = Modifier.padding(innerPadding),
                        onSearchClicked = { number ->
                            val searcher = BinarySearch()
                            val (index, steps) = searcher.findItem(number) // Unpacking the Pair
                            val worstCase = searcher.getWorstCase()

                            resultText = if (index != -1) {
                                "Found at index: $index\n" +
                                        "Steps(Comparisons) taken: $steps\n , and Halvings are $steps-1 because halvings are always log n\n" +
                                        "Worst case for 128 items with Binary Search: $worstCase steps"
                            } else {
                                "Not found. Steps taken: $steps\n" +
                                        "Worst case: $worstCase steps"
                            }
                        },
                        resultDisplay = resultText
                    )
                }
            }
        }
    }
}

@Composable
fun NumberInputExample(
    modifier: Modifier = Modifier,
    onSearchClicked: (Int) -> Unit,
    resultDisplay: String,
) {
    var inputString by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = inputString,
            onValueChange = { if (it.all { char -> char.isDigit() }) inputString = it },
            label = { Text("Search for number (1-128)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Button(
            onClick = {
                val num = inputString.toIntOrNull()
                if (num != null) onSearchClicked(num)
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Run Binary Search")
        }

        Text(text = resultDisplay)
    }
}
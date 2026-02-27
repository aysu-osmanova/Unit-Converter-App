package com.example.unitconverterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
                UnitConverterApp()
            }
        }
    }
}
@Composable
fun UnitConverterApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Text("Unit Converter" )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField( "",   {
                // Here goes what should happen, when the Value of our OutlinedTextfield changes
            })

            Row() {
                Box {
                    Button(  {/*TODO */ }) {
                        Text("Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = ""
                        )
                    }
                    DropdownMenu(true , { /*TODO*/}) {
                        DropdownMenuItem({ Text ("Centimeters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Meters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Kilometer ")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Millimeters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Foot")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Mile")},{ /*TODO*/})
                    }

                }
                Spacer(modifier = Modifier.width(16.dp))

                Box {
                    Button(  {/*TODO */ }) {
                        Text("Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = ""
                        )
                    }
                    DropdownMenu(true , { /*TODO*/}) {
                        DropdownMenuItem({ Text ("Centimeters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Meters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Kilometer ")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Millimeters")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Foot")},{ /*TODO*/})
                        DropdownMenuItem({ Text ("Mile")},{ /*TODO*/})
                    }
                }

            }

            Text("Result:")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterAppPreview(){
    UnitConverterApp()
}
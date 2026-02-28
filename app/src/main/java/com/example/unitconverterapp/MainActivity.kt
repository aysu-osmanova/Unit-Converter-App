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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import kotlin.math.roundToInt

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
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(1.00) }
    var oConversionFactor = remember { mutableStateOf(1.00) }


    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() /100.0
        outputValue=result.toString()

    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF5F7FA) ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ){

            Text("Unit Converter",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF3F51B5))
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                inputValue,
                {
                inputValue = it
                    convertUnits()
                // Here goes what should happen, when the Value of our OutlinedTextfield changes
                },
                label = {Text ("Enter Value: ")})

            Row() {
                // input box
                Box {
                    //input button
                    Button(  {iExpanded=true}) {
                        Text(inputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = ""
                        )
                    }
                    DropdownMenu(iExpanded , { iExpanded=false}) {
                        DropdownMenuItem(
                            { Text ("Centimeters")},
                            {
                                iExpanded=false
                                inputUnit="Centimeters"
                                conversionFactor.value=0.01
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Meters")},
                            {
                                iExpanded=false
                                inputUnit="Meters"
                                conversionFactor.value=1.00
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Kilometers")},
                            {
                                iExpanded=false
                                inputUnit="Kilometers"
                                conversionFactor.value=1000.0
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Millimeters")},
                            {
                                iExpanded=false
                                inputUnit="Millimeters"
                                conversionFactor.value=0.001
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Foot")},
                            {
                                iExpanded=false
                                inputUnit="Foot"
                                conversionFactor.value=0.3048
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Miles")},
                            {
                                iExpanded=false
                                inputUnit="Miles"
                                conversionFactor.value=1609.344
                                convertUnits()
                            })
                    }

                }
                Spacer(modifier = Modifier.width(16.dp))
                //output box
                Box {
                    //output button
                    Button(  {oExpanded= true}) {
                        Text(outputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = ""
                        )
                    }
                    DropdownMenu(oExpanded , {oExpanded=false}) {
                        DropdownMenuItem(
                            { Text ("Centimeters")},
                            {
                                oExpanded=false
                                outputUnit="Centimeters"
                                oConversionFactor.value=0.01
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Meters")},
                            {
                                oExpanded=false
                                outputUnit="Meters"
                                oConversionFactor.value=1.00
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Kilometers")},
                            {
                                oExpanded=false
                                outputUnit="Kilometers"
                                oConversionFactor.value=1000.0
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Millimeters")},
                            {
                                oExpanded=false
                                outputUnit="Millimeters"
                                oConversionFactor.value=0.001
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Foot")},
                            {
                                oExpanded=false
                                outputUnit="Foot"
                                oConversionFactor.value=0.3048
                                convertUnits()
                            })
                        DropdownMenuItem(
                            { Text ("Miles")},
                            {
                                oExpanded=false
                                outputUnit="Miles"
                                oConversionFactor.value=1609.344
                                convertUnits()
                            })
                    }
                }

            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Result: $outputValue $outputUnit",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.DarkGray)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterAppPreview(){
    UnitConverterApp()
}
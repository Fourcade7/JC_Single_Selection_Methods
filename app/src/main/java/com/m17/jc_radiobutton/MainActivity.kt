package com.m17.jc_radiobutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m17.jc_radiobutton.ui.theme.JC_RadioButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JC_RadioButtonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RadioButtonExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun LazySingleSelecion() {

    val array= arrayOf("Kotlin","Java","JavaScript","Swift")
    var sel by remember {
        mutableStateOf(array.get(0))
    }

    LazyColumn {
        itemsIndexed(array){index, item ->
//            Text(
//                modifier = Modifier
//                    .padding(15.dp)
//                    .clickable {
//                        sel=item
//                    },
//                text =item,
//                color = if (sel==item) Color.Red else Color.White
//
//            )
            Log.d("PR77777", "LazySingleSelecion: RECOMPOSITION ?")

            LazyItem(text = item, color = if (sel==item) Color.Red else Color.White) {
                sel=item
            }
        }
    }



}

@Composable
fun LazyItem(text:String,color: Color,onClick:()->Unit) {
    Text(
        modifier = Modifier
            .padding(15.dp)
            .clickable {
                onClick()
            },
        text =text,
        color = color

    )
}



@Composable
fun RadioButtonExample(modifier: Modifier = Modifier) {

    Column(modifier=modifier) {
        LazySingleSelecion()
        Divider()

        val languages = listOf("Kotlin", "Java", "Javascript", "Rust")


        var sel by remember {
            mutableStateOf(languages.get(0))
        }


        Column {
            Text(text = sel, fontSize = 28.sp, modifier = Modifier.padding(10.dp))
            Row(modifier=Modifier.horizontalScroll(rememberScrollState())) {
                languages.forEach { text ->

                    Row(  verticalAlignment = Alignment.CenterVertically)
                    {

                        RadioButton(

                            selected = (text == sel),
                            onClick = {
                               sel=text
                            }
                        )
                        Text( text = text, fontSize = 24.sp )
                    }
                }
            }
        }




    }

}

@Preview(showBackground = true)
@Composable
fun RadioButtonExamplePreview() {
    JC_RadioButtonTheme {

    }
}
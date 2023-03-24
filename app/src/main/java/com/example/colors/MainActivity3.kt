package com.example.colors

/*import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colors.ui.theme.ColorsTheme

*/

//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colors.ui.theme.ColorsTheme

class MainActivity3 : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

var colorGame = ColorsGame()
@Composable

fun colorSection(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        var proposedTextColor by remember { mutableStateOf(colorGame.proposedTextColor) }
        var proposedBackColor by remember { mutableStateOf(colorGame.proposedBackColor) }

        var targetTextColor by remember { mutableStateOf(colorGame.targetTextColor) }
        var targetBackColor by remember { mutableStateOf(colorGame.targetBackColor) }




        Text(text = stringResource(R.string.Proposed_color),
            color = Color(proposedTextColor),

            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(proposedBackColor))
                .weight(1f)
        )
        Text(stringResource(R.string.Target_color),
            color = Color(targetTextColor),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(targetBackColor))
                .weight(1f)
        )
    }
}


@Composable
fun SliderSection(title: String,color: Color,value:Float){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        var sliderPosition by remember { mutableStateOf(value) }
        Text(text = sliderPosition.toString())
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it }, valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTickColor = color,
                inactiveTickColor = Color.Gray,


            ), modifier = Modifier
                .weight(1f))
    }

}


/*
*
* var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })*/




fun restart()  {
    colorGame.restartGame()

}

@Composable
fun buttonSection(

){
    Row(
        verticalAlignment = Alignment.CenterVertically

    ){
        Button(onClick = {
            restart()

        },modifier = Modifier
            .weight(1f)
            .padding(10.dp)
        ){
            Text(stringResource(R.string.New))
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically

    ){
        Button(onClick = {
           //la fun show score está en la clase activity 2
        },modifier = Modifier
            .weight(1f)
            .padding(10.dp)
        ){
            Text(stringResource(R.string.Score))
        }

    }
    
}

@Composable

fun MyUI() {

    Column ( modifier= Modifier
        .background(Color.White)
        .fillMaxSize()
        .padding(20.dp))


    {
        Row(
            modifier = Modifier
                .weight(1f)

        ){
            colorSection()

        }

        SliderSection(title = stringResource(R.string.Red), color = Color.Red, value = 128f)
        SliderSection(title = stringResource(R.string.Green), color = Color.Green, value = 54f)
        SliderSection(title = stringResource(R.string.Blue), color = Color.Blue, value = 220f)

        buttonSection()
        

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ColorsTheme {
        MyUI()
    }
}
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
import android.util.Half.toFloat
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import com.example.colors.ui.theme.ColorsTheme
import android.graphics.Color as colorcito

class MainActivity3 : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

var colorGame = ColorsGame()
@Composable

fun colorSection(proposedTextColor:Int,proposedBackColor:Int
, targetTextColor:Int, targetBackColor: Int){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

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
fun SliderSection(title: String,color: Color,value:Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        var sliderPosition by remember { mutableStateOf(value) }
        Text(text = sliderPosition.toString())
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it  }, valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTickColor = color,
                inactiveTickColor = Color.Gray,


            ), modifier = Modifier
                .weight(1f))

        var redValue = 0
        var greenValue =0
        var blueValue = 0

        if(title=="RED"){ redValue=sliderPosition.toInt()}

        else if (title=="GREEN"){greenValue=sliderPosition.toInt()}
        else if (title=="BLUE"){blueValue=sliderPosition.toInt()}








    }

}

fun updateValues(r:Int,g:Int,b:Int) {

    val newBackColor = colorcito.rgb(r, g, b)
    colorGame.proposedBackColor = newBackColor
}



/*
@Composable
fun restart()  {
    colorGame.restartGame()

}

@Composable
fun buttonSection(onClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = { onClick

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
*/


@Composable

fun MyUI() {


    var proposedTextColor by remember { mutableStateOf(colorGame.proposedTextColor) }
    var proposedBackColor by remember { mutableStateOf(colorGame.proposedBackColor) }

    var targetTextColor by remember { mutableStateOf(colorGame.targetTextColor) }
    var targetBackColor by remember { mutableStateOf(colorGame.targetBackColor) }


    Column ( modifier= Modifier
        .background(Color.White)
        .fillMaxSize()
        .padding(20.dp))

    {
        Row(
            modifier = Modifier
                .weight(1f)

        ){
            colorSection(colorGame.proposedTextColor,colorGame.proposedBackColor,targetTextColor,targetBackColor)
        }

        SliderSection(title = "RED" , color = Color.Red, value = colorcito.red(colorGame.proposedBackColor).toFloat())
        SliderSection(title = "GREEN", color = Color.Green, value = colorcito.green(colorGame.proposedBackColor).toFloat())
        SliderSection(title = "BLUE" , color = Color.Blue, value = colorcito.blue(colorGame.proposedBackColor).toFloat())

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = {
                colorGame.restartGame()
                proposedTextColor= colorGame.proposedTextColor
                proposedBackColor= colorGame.proposedBackColors

                targetTextColor = colorGame.targetTextColor
                targetBackColor= colorGame.targetBackColor
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
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ColorsTheme {
        MyUI()
    }
}
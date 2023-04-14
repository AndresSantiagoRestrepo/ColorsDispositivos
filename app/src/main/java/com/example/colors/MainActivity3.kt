package com.example.colors

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
import java.util.*
import android.graphics.Color as colorcito

class MainActivity3 : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

var colorGame = ColorsGame()
var textoTips =""
@Composable

fun colorSection(proposedTextColor:Int,proposedBackColor:Color,targetTextColor:Int, targetBackColor: Int){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

        Text(text = stringResource(R.string.Proposed_color),
            color = Color(proposedTextColor),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .background(proposedBackColor)
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

/*
@Composable
fun SliderSection(title: String,color: Color,value:Float) {
    //el value es un solo float, cada slider tiene una valor float diferente
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = value.toString())
        Slider(value = value, onValueChange = { value = it  }, valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTickColor = color,
                inactiveTickColor = Color.Gray,
            ), modifier = Modifier
                .weight(1f))
    }

}
*/
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


fun showScore() {
    val RED = (R.string.Red)
    val GREEN = (R.string.Green)
    val BLUE = (R.string.Blue)
    val VERY_LOW = (R.string.Very_low)
    val LOW = (R.string.Low)
    val VERY_HIGH = (R.string.Very_high)
    val HIGH = (R.string.High)
    val targetColor = colorGame.targetBackColor
    val proposedColor = colorGame.proposedBackColors


    val text = StringBuilder()
    val tips = StringBuilder()
    val redDiff = android.graphics.Color.red(targetColor) - android.graphics.Color.red(proposedColor)
    val greenDiff = android.graphics.Color.green(targetColor) - android.graphics.Color.green(proposedColor)
    val blueDiff = android.graphics.Color.blue(targetColor) - android.graphics.Color.blue(proposedColor)
    val msg = colorGame.score.toString() + R.string.Your_score_is
    text.append(msg)


    //Tips para red
    if (redDiff > 10) {
        tips.append("\n")
        tips.append("Red is very low")
    } else if (redDiff > 0) {
        tips.append("\n")
        tips.append("Red is low")
    } else if (redDiff < -10) {
        tips.append("\n")
        tips.append("Red is very high")
    } else if (redDiff < 0) {
        tips.append("\n")
        tips.append("Red is high")
    }
/*
    //tips para green
    if (greenDiff > 10) {
        tips.append("\n")
        tips.append((R.string.X_is_Y, GREEN.lowercase(Locale.getDefault()), VERY_LOW.lowercase(
            Locale.getDefault())))
    } else if (greenDiff > 0) {
        tips.append("\n")
        tips.append(stringResource(R.string.X_is_Y, GREEN.lowercase(Locale.getDefault()), LOW.lowercase(
            Locale.getDefault())))
    } else if (greenDiff < -10) {
        tips.append("\n")
        tips.append(stringResource(R.string.X_is_Y, GREEN.lowercase(Locale.getDefault()), VERY_HIGH.lowercase(
            Locale.getDefault())))
    } else if (greenDiff < 0) {
        tips.append("\n")
        tips.append(stringResource(R.string.X_is_Y, GREEN.lowercase(Locale.getDefault()), HIGH.lowercase(
            Locale.getDefault())))
    }


    // tips para blue
    if (blueDiff > 10) {
        tips.append("\n")
        tips.append((R.string.X_is_Y, BLUE, VERY_LOW.lowercase(
            Locale.getDefault())))
    } else if (blueDiff > 0) {
        tips.append("\n")
        tips.append((R.string.X_is_Y, BLUE, LOW.lowercase(
            Locale.getDefault())))
    } else if (blueDiff < -10) {
        tips.append("\n")
        tips.append((R.string.X_is_Y, BLUE, VERY_HIGH)
    } else if (blueDiff < 0) {
        tips.append("\n")
        tips.append((R.string.X_is_Y, BLUE, HIGH))
    }
    */

    if (tips.length > 0) {
        text.append("\n\n")
        text.append((R.string.Tips))
        text.append(": ")
        text.append(tips)
    }


    textoTips=text.toString()



}



@Composable
fun MyUI() {
    var proposedTextColor by remember { mutableStateOf(colorGame.proposedTextColor) }
    var proposedBackColor by remember { mutableStateOf(colorGame.proposedBackColor) }

    var targetTextColor by remember { mutableStateOf(colorGame.targetTextColor) }
    var targetBackColor by remember { mutableStateOf(colorGame.targetBackColor) }

    var redValue by remember { mutableStateOf(colorcito.red(proposedBackColor).toFloat()) }
    var greenValue by remember {mutableStateOf(colorcito.green(proposedBackColor).toFloat())}
    var blueValue by remember { mutableStateOf(colorcito.blue(proposedBackColor).toFloat()) }



    Column ( modifier= Modifier
        .background(Color.White)
        .fillMaxSize()
        .padding(20.dp))

    {
        Row(
            modifier = Modifier
                .weight(1f)

        ){
            colorSection(colorGame.proposedTextColor,Color(redValue/255f,greenValue/255f,blueValue/255f),targetTextColor,targetBackColor)
        }

        //Slider section REd
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = ((redValue).toInt()).toString(),modifier = Modifier
                .width(30.dp))
            Slider(value = redValue, onValueChange = { redValue = it  }, valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Red,
                    activeTickColor = Color.Red,
                    inactiveTickColor = Color.Gray,
                ), modifier = Modifier
                    .weight(1f))
        }

        //Slider Green
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = ((greenValue).toInt()).toString(),modifier = Modifier
                .width(30.dp))
            Slider(value = greenValue, onValueChange = { greenValue = it  }, valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Green,
                    activeTickColor = Color.Green,
                    inactiveTickColor = Color.Gray,
                ), modifier = Modifier
                    .weight(1f))
        }

        //Slider Blue
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = ((blueValue).toInt()).toString(),modifier = Modifier
                .width(30.dp))

            Slider(value = blueValue, onValueChange = { blueValue = it  }, valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Blue,
                    activeTickColor = Color.Blue,
                    inactiveTickColor = Color.Gray,
                ), modifier = Modifier
                    .weight(1f))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = {
                redValue=colorcito.red(proposedBackColor).toFloat()
                greenValue=colorcito.green(proposedBackColor).toFloat()
                blueValue=colorcito.blue(proposedBackColor).toFloat()



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
               showScore()
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
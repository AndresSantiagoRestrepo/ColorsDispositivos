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
    //el value es un solo float, cada slider tiene una valor float diferente
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
            colorSection(colorGame.proposedTextColor,colorGame.proposedBackColor,targetTextColor,targetBackColor)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = redValue.toString())
            Slider(value = redValue, onValueChange = { redValue = it  }, valueRange = 0f..255f,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Red,
                    activeTickColor = Color.Red,
                    inactiveTickColor = Color.Gray,
                ), modifier = Modifier
                    .weight(1f))
        }


        SliderSection(title = "GREEN", color = Color.Green, value = greenValue)
        SliderSection(title = "BLUE" , color = Color.Blue, value = blueValue)

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
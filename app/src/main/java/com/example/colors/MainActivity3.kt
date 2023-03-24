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
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable

fun colorSection(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(R.string.Proposed_color),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(ColorsGame.randomColor()))
                .weight(1f)
        )
        Text(text = stringResource(R.string.Target_color),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(ColorsGame.randomColor()))
                .weight(1f)
        )
    }
}


@Composable
fun SliderSection(title: String,color: Color,value:Float){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Slider(value = value, onValueChange = {}, valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTickColor = color,
                inactiveTickColor = Color.Gray

            ), modifier = Modifier
                .weight(1f))
    }

}

@Composable
fun buttonSection(
    title: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

    }
}

@Composable

fun MyUI() {
    Column ( modifier= Modifier
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

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorsTheme {
        MyUI()
    }
}
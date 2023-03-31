import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colors.ui.theme.ColorsTheme

@Composable
fun MyUI() {
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, Jetpack Compose!",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .background(color = backgroundColor)
                .padding(16.dp)
        )
        Button(onClick = { backgroundColor = if (backgroundColor == Color.White) Color.Blue else Color.White }) {
            Text("Change background color")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyScreen() {
    MyUI()
}


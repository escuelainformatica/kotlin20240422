package cl.eftec.app20240422

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.eftec.app20240422.ui.theme.App20240422Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var srv by remember { mutableStateOf(ClaseServicio())}
            App20240422Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Column {
                        TextField(value = srv.compra.producto, onValueChange = {srv.compra.producto=it} )
                        TextField(value = srv.compra.precio.toString(), onValueChange = {
                            if(it!="") {
                                srv.compra.precio = it.toInt()
                            } else {
                                srv.compra.precio = 0
                            }
                        } )
                        TextField(value = srv.compra.cantidad.toString(), onValueChange = {
                            if(it!="") {
                                srv.compra.cantidad = it.toInt()
                            } else {
                                srv.compra.cantidad = 0
                            }
                        } )
                        ElevatedButton(onClick = { srv.agregar()}) {
                            Text("Agregar")
                        }
                        for(item in srv.listado) {
                            Tarjeta(item)
                        }
                        Text("Total : ${srv.totalCantidad}  precio:${srv.totalPrecio} ")
                    }

                }
            }
        }
    }
}
@Composable
fun Tarjeta(compra:Compra) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(painter = painterResource(R.drawable.apple), contentDescription = "xxx",Modifier.width(60.dp))
            Text(" ")
            Column {
                Text(compra.producto)
                Row {
                    Text(compra.precio.toString(),Modifier.fillMaxWidth(0.5f))
                    Text(compra.cantidad.toString(),Modifier.fillMaxWidth(0.5f))

                }

            }
        }
    }
    Text(" ")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App20240422Theme {
        Greeting("Android")
    }
}
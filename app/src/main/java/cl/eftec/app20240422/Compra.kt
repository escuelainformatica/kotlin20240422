package cl.eftec.app20240422

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Compra {
    var producto by  mutableStateOf("");
    var cantidad by  mutableStateOf(0);
    var precio by  mutableStateOf(0);

}
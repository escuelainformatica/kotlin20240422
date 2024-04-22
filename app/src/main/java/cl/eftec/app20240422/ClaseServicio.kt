package cl.eftec.app20240422

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ClaseServicio {
    var compra=Compra()
    var listado = mutableStateListOf<Compra>()
    var totalCantidad by  mutableStateOf(0);
    var totalPrecio by  mutableStateOf(0);

    fun agregar() {

        listado.add(compra)
        totalCantidad+=compra.cantidad
        totalPrecio+=compra.precio
        /*compra.producto="";
        compra.precio=0;
        compra.cantidad=0;*/
        compra=Compra()
        //    this.valor1=""
//        this.valor2=""
    }
}
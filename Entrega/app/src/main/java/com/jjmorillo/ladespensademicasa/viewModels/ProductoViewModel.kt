package com.jjmorillo.ladespensademicasa.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmorillo.ladespensademicasa.models.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//TODA CLASE VIEWMODEL EXTENDERA DE VIEWMODEL O DE ACTIVITYVIEWMODEL
/*EN CUANTO SE CREA LA CLASE PRODUCTOVIEWMODEL NOS CREA UNA VARIABLES
 PRODUCTOS QUE VA A HACER UN INICIALIZADOR NOS VA A CREAR UN OBJETO DE TIPO MUTABLELIVEDATA*/
class ProductoViewModel : ViewModel() {
    // EL BY LAZY ES INICIALIZADOR AUTOMATICO
    /*Estamos creando una variable con el nombre productos que es de tipo MutableLiveData
    // que la inicializamos a un mutablelivedata que esta vacio(en blaco) y además creamos la función cargarProductos*/
    private val _productos: MutableLiveData<List<Producto>> by lazy {

        //also --> Quiero hacer algo mas, además de crear la mutablelivedata, quiero introduir datos
        //En el also vamos a llamar a una función que generalmente tiene que ser asincrona
        MutableLiveData<List<Producto>>().also {
            cargarProductos()
        }

    }

    private fun cargarProductos() {
        //Añadir datos al mutable live data
        //SIMULANDO LA CONEXIÓN A LA BD

        //VAMOS A CREAR UNA CORUTINA
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val productos = mutableListOf<Producto>() //LISTA MUTABLE
                productos.add(Producto(1, "galletas dinosaurios", "gullon", "galletas de cereales 250 g", "galletas_principe", 1.55, 3.95))
                productos.add(Producto(2, "cereales chocolate", "kollbram", "cereales de chocolate con leche 500 g", "galletas_principe", 1.22, 2.85))
                productos.add(Producto(3, "cereale integrales sin gluten", "hacendado", "cereales sin gluten 450 g ", "galletas_principe", 0.65, 1.58))
                productos.add(Producto(4, "galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "galletas_principe", 0.85, 1.85))
                productos.add(Producto(5, "estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "galletas_principe", 0.95, 1.18))
                productos.add(Producto(6, "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "galletas_principe", 0.33, 1.05))
                productos.add(Producto(7, "galletas de chocolate", "principe", "deliciosas galletas de chocolate 300 g", "galletas_principe", 0.45, 2.40))
                productos.add(Producto(8, "galleta choco flakes", "cuetara", "galletas de choco leche 550 g", "galletas_principe", 0.65, 3.18))
                productos.add(Producto(9, "galleta principe mini", "principe", "galleta de chocolate 160 g", "galletas_principe", 0.55, 2.30))
                productos.add(Producto(10, "galleta chips ahoy", "chips ahoy", "irresistibles con chocolate 125 g", "galletas_principe", 0.70, 1.18))
                productos.add(Producto(11, "galletas con naranja", "flora", "galletas de cereales 160 g", "galletas_principe", 0.45, 1.65))
                productos.add(Producto(12, "galletas de nocilla", "nocilla", "galletas originales de nocilla 120 g", "galletas_principe", 0.85, 2.74))
                productos.add(Producto(13, "galletas de café", "reglero", "café regelo colombianos 260 g", "galletas_principe", 0.95, 3.52))
                productos.add(Producto(14, "galletas bio", "gullón", "bio organic digestive 270 g", "galletas_principe", 0.89, 3.29))
                _productos.postValue(productos)//MAIN THREAD
            }
        }


        //ESTO SERIA PARA PASAR DATOS
        //ESTO LO QUE HARIA ES ESPECIFICAR EL VALOR DEL CONTENIDO DEL LIVE DATA
        //_productos.value = productos //ESTE SE UTILIZA EN EL MAIN THREAD
        /*_productos.postValue(productos)//EN OTROS THREAD*/
    }

    //fun obtenerProductos()= _productos
    //Esto de abajo es lo mismo que lo de arriba
    /*LOS DATOS QUE ENVIAMOS SON FIJOS, PARA ESO SE CREA LA FUNCION
    COMO PROTECCION PARA EVITAR QUE SE MODIFIQUEN LOS DATOS QUE LE ENVIAMOS*/
    fun obtenerProductos(): LiveData<List<Producto>> {
        return _productos
    }


}
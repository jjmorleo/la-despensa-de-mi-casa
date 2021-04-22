package com.jjmorillo.ladespensademicasa.viewModels

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
                productos.add(Producto(1, "Galletas Dinosaurus", "ARTIACH", "Galletas Dinosaurus Huevo Artiach 140 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasdinosaurus.jpg?alt=media&token=dd4ac846-d676-4ef6-9367-9b00ce1f7a37", 10.00, 1.40))
                productos.add(Producto(2, "Cereales con chocolate belga", "kollbram", "Cereales con chocolate belga 375 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealeschocolatebelga.jpg?alt=media&token=7a0cb975-4e7d-493e-bb9c-61fe0b957da2", 7.33, 2.75))
                productos.add(Producto(3, "cereale integrales sin gluten", "hacendado", "cereales sin gluten 450 g ", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealesintegraleseco.jpg?alt=media&token=586c03c5-17dd-41f2-b2b0-5282ed2bf3b8", 11.17, 3.35))
                productos.add(Producto(4, "galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascookies.jpg?alt=media&token=eb2af291-99ce-4767-a9a7-245cc010ea89", 0.85, 1.85))
                productos.add(Producto(5, "estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasestrella.jpg?alt=media&token=38e9dc5c-d7f4-4b89-b31f-50395e5906ee", 0.95, 1.18))
                productos.add(Producto(6, "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasoreo.jpg?alt=media&token=8dbc8715-eb7e-4984-a8bf-91fc25ff1944", 6.80, 2.99))
                productos.add(Producto(7, "galletas de chocolate", "carrefour", "Galletas chocolate con leche Digestive Carrefour 300 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletaschocolate.jpg?alt=media&token=aa6773d4-a8c7-4e40-af62-114059812902", 2.67, 0.80))
                productos.add(Producto(8, "Galleta flakes choco", "cuetara", "Galleta flakes choco cuetara 550g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletachocoflakes.jpg?alt=media&token=1cd8d80d-78f4-43d5-9976-534783568433", 4.45, 2.45))
                productos.add(Producto(9, "galleta principe mini", "principe", "galleta de chocolate 160 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasprincipemini.jpg?alt=media&token=2d6df324-82b7-4e35-aa50-d8ab87912398", 9.06, 1.45))
                productos.add(Producto(10, "galleta chips ahoy", "chips ahoy", "irresistibles con chocolate 125 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/chipsahoy.jpg?alt=media&token=7d0cfd34-507c-4570-87ba-a4886596710c", 0.70, 1.18))
                productos.add(Producto(11, "galletas con naranja", "flora", "galletas de cereales 160 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletanaranja.jpg?alt=media&token=12782671-ad35-47b5-9ac7-5b96b8038b94", 0.45, 1.65))
                productos.add(Producto(12, "Galletas rellena cacao", "nocilla", "Galletas rellena con crema de cacao Nocilla 120 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasnocilla.jpg?alt=media&token=30bf5b13-b3cd-4227-a4d9-e3f7e0f99315", 0.85, 2.74))
                productos.add(Producto(13, "galletas de café", "reglero", "café regelo colombianos 260 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascafe.jpg?alt=media&token=c44e0e86-aebc-4c1d-b732-c9148125edf8", 0.95, 3.52))
                productos.add(Producto(14, "galletas bio", "gullón", "bio organic digestive 270 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasbio.jpg?alt=media&token=59a514bd-595f-40d1-988a-10aaa10b3624", 0.89, 3.29))
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

    fun obtenerofertas(): LiveData<List<Producto>> {
        val liveData= MutableLiveData<List<Producto>>()


        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Galletas Dinosaurus", "ARTIACH", "Galletas Dinosaurus Huevo Artiach 140 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasdinosaurus.jpg?alt=media&token=dd4ac846-d676-4ef6-9367-9b00ce1f7a37", 10.00, 1.40))
        productos.add(Producto(2, "Cereales con chocolate belga", "kollbram", "Cereales con chocolate belga 375 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealeschocolatebelga.jpg?alt=media&token=7a0cb975-4e7d-493e-bb9c-61fe0b957da2", 7.33, 2.75))
        productos.add(Producto(3, "cereale integrales sin gluten", "hacendado", "cereales sin gluten 450 g ", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealesintegraleseco.jpg?alt=media&token=586c03c5-17dd-41f2-b2b0-5282ed2bf3b8", 11.17, 3.35))
        productos.add(Producto(4, "galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascookies.jpg?alt=media&token=eb2af291-99ce-4767-a9a7-245cc010ea89", 0.85, 1.85))
        productos.add(Producto(5, "estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasestrella.jpg?alt=media&token=38e9dc5c-d7f4-4b89-b31f-50395e5906ee", 0.95, 1.18))
        productos.add(Producto(6, "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasoreo.jpg?alt=media&token=8dbc8715-eb7e-4984-a8bf-91fc25ff1944", 6.80, 2.99))
        productos.add(Producto(7, "galletas de chocolate", "carrefour", "Galletas chocolate con leche Digestive Carrefour 300 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletaschocolate.jpg?alt=media&token=aa6773d4-a8c7-4e40-af62-114059812902", 2.67, 0.80))
        productos.add(Producto(8, "Galleta flakes choco", "cuetara", "Galleta flakes choco cuetara 550g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletachocoflakes.jpg?alt=media&token=1cd8d80d-78f4-43d5-9976-534783568433", 4.45, 2.45))


        liveData.postValue(productos)//MAIN THREAD
        return liveData
    }


}
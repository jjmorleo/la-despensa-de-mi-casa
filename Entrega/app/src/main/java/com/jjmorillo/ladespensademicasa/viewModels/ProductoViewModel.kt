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
    fun obtenerFrutasVerduras():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()


        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Mango", "FRUTA", "Mango nacional a granel 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/mango.jpg?alt=media&token=821eab35-bcb4-4c2b-9a85-9ba1844e2da8", 1.12, 2.25))
        productos.add(Producto(2, "Kiwi", "ZESPRI", "Kiwi Zespri 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/kiwizespri.jpg?alt=media&token=552202bb-c089-49c0-80b1-341ad96bb24e", 3.99, 3.99))
        productos.add(Producto(3, "Piña", "MONTE", "Piña del Monte premium pieza 1,5 Kg aprox ", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pi%C3%B1a.jpg?alt=media&token=f68691c6-0767-4b51-83f0-ea1cebd39c35", 1.49, 2.23))
        productos.add(Producto(4, "Calabacín", "VERDURA", "Calabacín la despensa a granel 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabacin.jpg?alt=media&token=58a4e297-1f90-43a4-84fc-132e7fa0205e", 1.19, 1.19))
        productos.add(Producto(5, "Calabaza sepallo", "VERDURA", "Calabaza sepallo a granel 1,5 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabaza.jpg?alt=media&token=795df4f4-56e2-47c7-9f5b-12c5c9dc9469", 1.25, 1.87))
        productos.add(Producto(6, "Cebolla dulce selección", "FUENTE", "Cebolla dulce selección 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cebollafuente.jpg?alt=media&token=03f52d25-fc15-43cd-a773-5c4541f6c230", 1.99, 1.99))
        productos.add(Producto(7, "Aguacate", "FRUTA", "Aguacate de origen nacional 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aguacate.jpg?alt=media&token=20e670ad-5ea0-4422-a177-a5bd92da08b8", 4.00, 2.00))
        productos.add(Producto(8, "Espárrago verde", "VERDURAS", "Espárrago verde manojo de 300 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/esparrago.jpg?alt=media&token=a4b2adda-7a72-49c4-8ffe-7dec2d1f6c32", 3.83, 1.15))
        productos.add(Producto(8, "Berengena", "VERDURAS", "Berenjena a granel 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berengena.jpg?alt=media&token=a21d6c36-4ba3-4ed8-aece-27a16729c623", 3.83, 1.15))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }

    fun obtenerOfertas(): LiveData<List<Producto>> {
        val liveData = MutableLiveData<List<Producto>>()


        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Aguacate", "FRUTA", "Aguacate de origen nacional 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aguacate.jpg?alt=media&token=20e670ad-5ea0-4422-a177-a5bd92da08b8", 4.00, 2.00))
        productos.add(Producto(2, "Calabacín", "FRUTA", "Calabacín nacional a granel 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabacin.jpg?alt=media&token=58a4e297-1f90-43a4-84fc-132e7fa0205e", 1.19, 1.19))
        productos.add(Producto(3, "Cebolla dulce selección", "FUENTE", "Cebolla dulce selección 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cebollafuente.jpg?alt=media&token=03f52d25-fc15-43cd-a773-5c4541f6c230", 1.99, 1.99))
        productos.add(Producto(4, "galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascookies.jpg?alt=media&token=eb2af291-99ce-4767-a9a7-245cc010ea89", 0.85, 1.85))
        productos.add(Producto(5, "estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasestrella.jpg?alt=media&token=38e9dc5c-d7f4-4b89-b31f-50395e5906ee", 0.95, 1.18))
        productos.add(Producto(6, "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasoreo.jpg?alt=media&token=8dbc8715-eb7e-4984-a8bf-91fc25ff1944", 6.80, 2.99))
        productos.add(Producto(7, "galletas de chocolate", "carrefour", "Galletas chocolate con leche Digestive Carrefour 300 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletaschocolate.jpg?alt=media&token=aa6773d4-a8c7-4e40-af62-114059812902", 2.67, 0.80))
        productos.add(Producto(8, "Galleta flakes choco", "cuetara", "Galleta flakes choco cuetara 550g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletachocoflakes.jpg?alt=media&token=1cd8d80d-78f4-43d5-9976-534783568433", 4.45, 2.45))


        liveData.postValue(productos)//MAIN THREAD
        return liveData
    }


}
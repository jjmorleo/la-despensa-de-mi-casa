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
            //CONTEXTO DE ENTRADA Y SALIDA
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

    fun obtenerAlimentacion():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Azafrán en hebras", "CARMENCITA", "Azafrán en hebras Carmencita 0,375 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/azafr%C3%A1n.jpg?alt=media&token=12a87307-2752-4d8e-9497-26fe40f744cf", 72.90, 2.90))
        productos.add(Producto(2, "Levadura", "ROYAL", "Levadura Royal pack de 6 sobres de 16 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/levadura.jpg?alt=media&token=733b7f9e-f9a4-4dc3-b149-6bb54fc5b0bc", 23.25, 2.29))
        productos.add(Producto(3, "Arroz", "SOS", "Arroz redondo Sos 1 kg.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/arrozsos.jpg?alt=media&token=646a9edc-ccaa-4917-a1b7-3394b2440d5b", 1.55, 1.55))
        productos.add(Producto(4, "Alubia blanca", "LUENGO", "Alubia blanca categoría extra Luengo 1 kg.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/alubialuengo.jpg?alt=media&token=1ff3aa61-a114-437c-9d95-3e7032d7f5bc", 2.75, 2.75))
        productos.add(Producto(5, "Lenteja pardina", "LUENGO", "Lenteja pardina categoría extra Luengo 1 kg.x", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lentejaluengo.jpg?alt=media&token=6d822201-4eac-40da-a3d8-68e2c99be8e9", 3.05, 3.05))
        productos.add(Producto(6, "Aceite de oliva", "DCOOP", "Aceite de oliva virgen extra Dcoop garrafa 5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aceiteoliva.jpg?alt=media&token=fe888db9-95c0-4878-847a-f31186117a37", 2.09, 10.45))
        productos.add(Producto(7, "Mayonesa", "HELLMANN'S", "Mayonesa tarro 650 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/mayonesa.jpg?alt=media&token=a2d9a3ab-4aa6-40c0-8697-b2ebcf5872c8", 3.06, 1.99))
        productos.add(Producto(8, "Macarrones", "GALLO", "Macarrones plumas nº6 750 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/macarr%C3%B3ngallo.jpg?alt=media&token=d64a1d6f-9047-4eee-a44c-9790981a4053", 1.69, 1.27))
        productos.add(Producto(9, "Vinagre balsámico", "CARREFOUR", "Vinagre balsámico de módena Carrefour 250 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/vinagrevalsamico.jpg?alt=media&token=c0bee94f-9975-4548-9a8a-e0730528b963", 4.60, 1.15))
        productos.add(Producto(10, "Berengena", "VERDURAS", "Berenjena a granel 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berengena.jpg?alt=media&token=a21d6c36-4ba3-4ed8-aece-27a16729c623", 3.83, 1.15))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }
    fun obtenerBebidas():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Coca Cola zero", "COCACOLA", "Coca Cola zero azúcar pack 4 botellas 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cocacolazero.jpg?alt=media&token=cd68289a-f816-47af-a670-ce9011ff3979", 0.84, 6.76))
        productos.add(Producto(2, "Aquarius sabor limón zero", "ACUARIUSZERO", "Aquarius sabor limón zero botella 1.5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/acuariolimon.jpg?alt=media&token=e33445d2-d39f-4287-9b07-5ff1ea5d726b", 1.15, 1.72))
        productos.add(Producto(3, "Vino Semidulce", "DIAMANTE", "Diamante Semidulce Sin Crianza", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/diamante.jpg?alt=media&token=4556e200-a79c-4b0c-ad13-ce7ba957cda8", 3.99, 3.99))
        productos.add(Producto(4, "Fanta naranja", "COCACOLA", "Refresco de naranja Fanta con gas pack de 2 botellas de 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fantanaranja.jpg?alt=media&token=e9c2b5e9-387e-4d81-a694-1dda9465b705", 0.57, 2.28))
        productos.add(Producto(5, "Vino Blanco", "FOUR LINES", "Four Lines Blanco 2020", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fourlineblanco.jpg?alt=media&token=9f40bd08-5561-43a7-b249-9393f14c538e", 5.50, 5.50))
        productos.add(Producto(6, "Gaseosa", "LA CASERA", "Gaseosa La Casera cero calorías pack de 4 botellas de 1,5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/gaseosa.jpg?alt=media&token=ff78df50-d9af-40e3-b7b0-bb42cbd67708", 0.55, 3.30))
        productos.add(Producto(7, "Whisky", "JOHNNIE WALHER", "Johnnie Walker Double Black Whisky", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/joniwalker.jpg?alt=media&token=4d645ebf-a41a-425a-9a05-aefae7a311d3", 39.86, 27.90))
        productos.add(Producto(8,"Vino Rioja", "LUIS CAÑAS ", "Luis Cañas Tinto 2017", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/riojaluisca%C3%B1a.jpg?alt=media&token=4ac12d92-ebbc-488b-a10f-ea4963bfe8c3", 10.50, 10.50))
        productos.add(Producto(9, "Tónica Schweppes zero", "SCHWEPPES", "Tónica Schweppes zero lata 25 cl.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/tonicalatazero.jpg?alt=media&token=804ecf7b-5400-4b73-a51b-648214e05603", 2.88, 0.72))
        productos.add(Producto(10, "Vino frizzante", "YLLERA", "Yllera 5.5 Verdejo Frizzante", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yllera.jpg?alt=media&token=4e54030a-fa49-4f4f-9737-9e2d1bd76967", 5.69, 5.69))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }
    fun obtenerDrogueriaLimpieza():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Detergente ropa", "ARIEL", "Detergente líquido Alpine Ariel 50 lavados.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/ariel.jpg?alt=media&token=a0b4ad6b-266c-403e-a2af-0d5eb1fd5f16", 0.28, 13.95))
        productos.add(Producto(2, "Limpiador desinfectante", "SANYTOL", "Limpiador desinfectante multiusos sin lejía Sanytol 750 ml", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/desinfestante.jpg?alt=media&token=a38d1d60-8e0c-4bc9-9554-2d8c14b54bbb", 3.13, 2.35))
        productos.add(Producto(3, "Limpiador de baño", "DON LIMPIO", "Limpiador de baño Don Limpio 1,5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/diamante.jpg?alt=media&token=4556e200-a79c-4b0c-ad13-ce7ba957cda8", 1.50, 2.25))
        productos.add(Producto(4, "Fanta naranja", "COCACOLA", "Refresco de naranja Fanta con gas pack de 2 botellas de 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fantanaranja.jpg?alt=media&token=e9c2b5e9-387e-4d81-a694-1dda9465b705", 0.57, 2.28))
        productos.add(Producto(5, "Vino Blanco", "FOUR LINES", "Four Lines Blanco 2020", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fourlineblanco.jpg?alt=media&token=9f40bd08-5561-43a7-b249-9393f14c538e", 5.50, 5.50))
        productos.add(Producto(6, "Gaseosa", "LA CASERA", "Gaseosa La Casera cero calorías pack de 4 botellas de 1,5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/gaseosa.jpg?alt=media&token=ff78df50-d9af-40e3-b7b0-bb42cbd67708", 0.55, 3.30))
        productos.add(Producto(7, "Whisky", "JOHNNIE WALHER", "Johnnie Walker Double Black Whisky", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/joniwalker.jpg?alt=media&token=4d645ebf-a41a-425a-9a05-aefae7a311d3", 39.86, 27.90))
        productos.add(Producto(8,"Vino Rioja", "LUIS CAÑAS ", "Luis Cañas Tinto 2017", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/riojaluisca%C3%B1a.jpg?alt=media&token=4ac12d92-ebbc-488b-a10f-ea4963bfe8c3", 10.50, 10.50))
        productos.add(Producto(9, "Tónica Schweppes zero", "SCHWEPPES", "Tónica Schweppes zero lata 25 cl.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/tonicalatazero.jpg?alt=media&token=804ecf7b-5400-4b73-a51b-648214e05603", 2.88, 0.72))
        productos.add(Producto(10, "Vino frizzante", "YLLERA", "Yllera 5.5 Verdejo Frizzante", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yllera.jpg?alt=media&token=4e54030a-fa49-4f4f-9737-9e2d1bd76967", 5.69, 5.69))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

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
        productos.add(Producto(9, "Berengena", "VERDURAS", "Berenjena a granel 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berengena.jpg?alt=media&token=a21d6c36-4ba3-4ed8-aece-27a16729c623", 3.83, 1.15))
        productos.add(Producto(10, "Plátano", "COPLACA", "Plátano de Canarias 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/platano.jpg?alt=media&token=90896c21-7f5d-4c9b-ab43-7683cb059e74", 3.95, 2.00))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }



    fun obtenerCarnes():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Preparado de carne picada", "AVINATUR", "Preparado de carne picada de vacuno 2x450 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/carnepicada.jpg?alt=media&token=585dd623-59fa-4d10-bad8-8bed90db2374", 5.21, 4.69))
        productos.add(Producto(2, "Lomo de cerdo adobado", "PAVOFRIO", "Lomo de cerdo adobado fileteado 650 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lomoadobado.jpg?alt=media&token=2b5fc3a1-5c12-43fc-92e9-df382e6e2e7e", 6.50, 4.22))
        productos.add(Producto(3, "Pechuga de pollo", "PAVISO", "Pechuga de pollo certificado en filetes 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pechugapollo.jpg?alt=media&token=52d951e2-df39-4c9e-8777-2d458aa47bad", 8.29, 4.14))
        productos.add(Producto(4, "Entrecot de vacuno", "PAVISO", "Entrecot de vacuno para la piedra 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/entrcotternera.jpg?alt=media&token=4c5ac398-d85c-4f06-84df-b5845c63ba1a", 10.95, 5.45))
        productos.add(Producto(5, "Trozo lomo cerdo ", "AVINATUR", "Trozo de lomo de cerdo 1,2 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/trozolomocerdo.jpg?alt=media&token=b6145be6-220b-4bc1-a0eb-a36be36cfb76", 3.95, 4.74))
        productos.add(Producto(6, "Pechuga de pollo campero", "PAVISO", "Pechuga de pollo campero fileteada 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pechugacampero.jpg?alt=media&token=2a68006a-7f1e-4244-b336-8bb84436ce64", 13.99, 6.99))
        productos.add(Producto(7, "Hamburguesa añojo", "AVINATUR", "Hamburguesa añojo 6x90 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/hamburguesaa%C3%B1ojo.jpg?alt=media&token=7e80d3c2-f77e-4714-8d3c-0e3290537243", 6.28, 3.39))
        productos.add(Producto(8, "Chuleta aguja de cerdo ", "AVINATUR", "Chuleta aguja de cerdo 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/chuletacerdo.jpg?alt=media&token=085c80e3-1215-49b8-bec3-5d01f399c0ac", 3.99, 3.99))
        productos.add(Producto(9, "Solomillo vacuno", "CANALVISO", "solomillo vacuno 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/solomillovacuno.jpg?alt=media&token=be53cfa4-3993-4ea5-b67f-5df2d19ad14f", 19.95, 9.97))
        productos.add(Producto(10, "Jamoncitos de pollo", "AVINATUR", "Jamoncitos de pollo 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/jamoncitospollo.jpg?alt=media&token=19b0bcb4-6948-4d7c-9bb8-176c7321f939", 3.45, 3.45))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }

    fun obtenerLacteos():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Yogur bífidus", "DANONE", "Yogur bífidus desnatado edulcorado natural Danone Activia pack de 8 unidades de 120 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurbifidus.jpg?alt=media&token=83ad70d6-6b03-4500-a470-ba124b5eabb4", 3.06, 3.06))
        productos.add(Producto(2, "Yogur con bolitas", "NESTLÉ", "Yogur con bolitas cubiertas de chocolate Mix-in Nestlé Kit Kat pack de 2 unidades de 115 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurbolitas.jpg?alt=media&token=604ad726-f605-4cd4-a273-809a67e2df25", 6.52, 1.50))
        productos.add(Producto(3, "Yogur leche de cabra", "GOSHUA", "Yogur natural de leche de cabra Goshua 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurcabra.jpg?alt=media&token=d0959b57-a5fc-4978-9942-71363c60a1b6", 8.76, 2.19))
        productos.add(Producto(4, "Yogur con fresa", "NESTLÉ", "Yogur con fresa Nestlé La Lechera sin gluten pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurfresa.jpg?alt=media&token=cc3dacd3-0185-41f1-adb8-504e6138593a", 4.56, 1.14))
        productos.add(Producto(5, "Yogur de fresa con grageas", "NESTLÉ", "Yogur de fresa con grageas de chocolate Nestlé Smarties pack de 2 unidades de 128 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurgragea.jpg?alt=media&token=6dc32825-27f1-4a2d-a3ad-96de40b96dd5", 5.86, 1.50))
        productos.add(Producto(6, "Yogur agrupado", "DANONE", "Yogur de fresa, macedonia, galleta y fresa-plátano Danone sin gluten pack de 12 unidades", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmacedonia.jpg?alt=media&token=7fa9dd8b-19ed-478b-b713-ab6c70e080a5", 1.93, 2.78))
        productos.add(Producto(7, "Yogur de mango", "PASTORET", "Yogur de mango ecológico Pastoret 135 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmango.jpg?alt=media&token=39c4b686-82e7-48ea-9571-a5031cce5626", 10.52, 1.42))
        productos.add(Producto(8, "Yoyur melocotón", "LALECHERA", "Yogur con melocotón Nestlé La Lechera sin gluten pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmelocoton.jpg?alt=media&token=b751f70a-3555-4744-8609-f2763acb9ca7", 4.56, 1.14))
        productos.add(Producto(9, "Yogur griego ", "DANONE", "Yogur griego con stracciatella Danone Oikos sin gluten pack de 4 unidades de 110 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yoguroikos.jpg?alt=media&token=fbb64724-12ed-483e-aeaf-84dc995ce71d", 4.82, 2.12))
        productos.add(Producto(10, "Yogur con leche de oveja", "GOSHUA", "Yogur con leche de oveja natural Goshua pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yoguroveja.jpg?alt=media&token=45c60054-4221-4aa1-95f3-760b8f3a573a", 7.36, 1.84))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }


    fun obtenerNovedades(): LiveData<List<Producto>> {
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



    fun obtenerPanBolleria():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Pan picos", "PANADERA", "Pan de picos la despensa 1 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpicos.jpg?alt=media&token=ed30c493-6259-453a-8f42-66d1ef0fa8d6", 1.68, 0.57))
        productos.add(Producto(2, "Pan de pueblo", "PANADERA", "Pan de pueblo sin aditivos 800 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpueblo.jpg?alt=media&token=949cd4bd-fc5e-4bba-bc33-d3b5ce8100d0", 1.44, 1.15))
        productos.add(Producto(3, "Pan payés", "PANADERA", "Pan payés grande Hecho aquí Carrefour 800 gx", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpayes.jpg?alt=media&token=0aaa47a2-4973-4d84-9a97-de0976014af3", 2.55, 2.55))
        productos.add(Producto(4, "Pan antaño", "PANADERA", "Pan de antaño Carrefour 1 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pananta%C3%B1o.jpg?alt=media&token=1704a70a-fa6b-42a4-aa46-d2b00e4c9c96", 3.62, 1.45))
        productos.add(Producto(5, "Pan gallego ", "PANADERA", "Pan gallego de cereales sin lactosa 70 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pangallego.jpg?alt=media&token=bed68339-f2a6-4768-9efa-ff707525fd24", 4.14, 0.29))
        productos.add(Producto(6, "Berlina bombón", "PANADERA", "Berlinas bombón 4 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berlinabombon.jpg?alt=media&token=08e22e45-04de-4870-beff-6f8c3d6bc1f0", 5.37, 1.15))
        productos.add(Producto(7, "Bretzel de chocolate", "PANADERA", "Bretzel de chocolate y mantequilla 100 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/brezelchocolate.jpg?alt=media&token=da584ed4-06ea-4150-b75f-ac68f475950c", 8.50, 0.85))
        productos.add(Producto(8, "Magdalena", "PANADERA", "Magdalenas caseras 420 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/magdalena.jpg?alt=media&token=f08a96a7-382c-43a3-a66d-2ef4f79212ab", 7.12, 2.99))
        productos.add(Producto(9, "Pastel manzana", "PANADERA", "Pastel de manzana 125 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pastelmanzana.jpg?alt=media&token=c4913231-847c-43b6-811b-d40e9af2e0f1", 6.80, 0.85))
        productos.add(Producto(10, "Bizcocho", "PANADERA", "Bizcocho casero 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/bizcocho.jpg?alt=media&token=3c98482b-1d6f-430d-82ad-61bed4aea04c", 6.00, 3.00))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }
    fun obtenerPescados():LiveData<List<Producto>>{

        val liveData = MutableLiveData<List<Producto>>()

        val productos = mutableListOf<Producto>() //LISTA MUTABLE
        productos.add(Producto(1, "Lubina", "PESCADO", "Lubina de ración 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lubina.jpg?alt=media&token=16ec7cf7-79ed-43b4-800f-35d8c879af54", 6.45, 3.22))
        productos.add(Producto(2, "Dorada", "PESCADO", "Dorada de ración 500 g aprox.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/dorada.jpg?alt=media&token=94598e24-cfa3-4bed-8c76-8db6a04fbee7", 7.45, 3.75))
        productos.add(Producto(3, "Lomo Atún", "PESCADO", "Lomo de atún 300 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lomoatun.jpg?alt=media&token=e825a791-a613-484f-bbdc-b4787e770f58", 10.90, 3.27))
        productos.add(Producto(4, "Lenguado", "PESCADO", "Lenguado ración 125 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lenguado.jpg?alt=media&token=0bc6447b-ac4b-495f-9c75-b52eaab606db", 11.90, 1.49))
        productos.add(Producto(5, "Gallo", "PESCADO", "Gallo ración 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/gallo.jpg?alt=media&token=6829d449-7d33-4805-a8cd-b3e78ece3f64", 7.99, 3.99))
        productos.add(Producto(6, "Boquerones", "PESCADO", "Boquerones 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/boquerones.jpg?alt=media&token=4caeaef6-4921-435c-a797-a79d45fa2d5d", 3.90, 1.95))
        productos.add(Producto(7, "Bacaladilla", "PESCADO'S", "Bacaladilla 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/bacaladilla.jpg?alt=media&token=c96528dd-f177-473a-994b-5b9cbb5c5dc9", 1.95, 0.99))
        productos.add(Producto(8, "Trucha", "PESCADO", "Trucha asalmonada Círculo de Calidad 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/trucha.jpg?alt=media&token=38b21256-5908-41a9-8e60-980f3b271f07", 6.25, 3.12))
        productos.add(Producto(9, "Salmón", "PESCADO", "Salmón Calidad y Origen Carrefour 1 ud de 3 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/salmon.jpg?alt=media&token=a7a2d18b-7635-4ffd-add2-6da3e1b7ac52", 8.75, 21.87))
        productos.add(Producto(10, "Pescadilla", "PESCADO", "Pescadilla fina 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pescadilla.jpg?alt=media&token=52ffbc06-5484-4d6c-a405-85e0f39647e9", 5.90, 5.90))

        liveData.postValue(productos)//MAIN THREAD
        return liveData

    }


}
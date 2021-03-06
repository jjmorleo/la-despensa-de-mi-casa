package com.jjmorillo.ladespensademicasa.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.converter.Converters
import com.jjmorillo.ladespensademicasa.database.daos.*
import com.jjmorillo.ladespensademicasa.database.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Database(entities = arrayOf(Usuario::class, Tornillo::class, Producto::class, Pedido::class, PedidosProductosCrossRef::class ), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao //ESTO ES UNA FUNCION ABSTRACTA Y VA A DEVOLVER UN UsuarioDAO y se llama usuarioDao()
    abstract fun mainDao(): MainDao
    abstract fun tornilloDao(): TornilloDao
    abstract fun productoDao(): ProductoDao
    abstract fun pedidoDao(): PedidoDao

    companion object {
        private var instance: AppDatabase? = null
        private const val NAME_DB = "La despensa de mi casa"

        fun newInstance(context: Context): AppDatabase {

            if (instance == null) {//AQUI INICIALIZAMOS LA BASE DE DATOS
                instance = Room.databaseBuilder(context, AppDatabase::class.java, NAME_DB)
                    .addCallback(callback)
                    .build()
            }
            return instance!!

        }
        //CALLBACK ES UNA ASBTRACT CLAAS POR ESO SE LE PONE OBJECT
        //EN ESTE CASO CUANDO PONEMOS LAS LLAVES LO QUE HACEMOS ES UNA IMPLEMENTACION DE ONCREATE
        //ESTO SE REALIZA CUANDO QUEREMOS PREINSERTAR DATOS AL INICIO
        private val callback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                GlobalScope.launch {
                    //INSERCION DE DATOS
                    //AQUI PODEMOS INSERTAR UN USUARIO DE FORMA PREDETERMINADA
                    withContext(Dispatchers.IO) {//ESTO SERIA UN EJEMPLO DE COMO INSERTAR USUARIO EN LA BASE DE DATOS PARA SIEMPRE

                        App.obtenerDB().productoDao().save(Producto("Cereales con chocolate belga", "kollbram", "Cereales con chocolate belga 375 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealeschocolatebelga.jpg?alt=media&token=7a0cb975-4e7d-493e-bb9c-61fe0b957da2", 7.33, 2.75,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascookies.jpg?alt=media&token=eb2af291-99ce-4767-a9a7-245cc010ea89", 0.85, 1.85,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("Galletas Dinosaurus", "ARTIACH", "Galletas Dinosaurus Huevo Artiach 140 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasdinosaurus.jpg?alt=media&token=dd4ac846-d676-4ef6-9367-9b00ce1f7a37", 10.00, 1.40,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("cereale integrales sin gluten", "hacendado", "cereales sin gluten 450 g ", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cerealesintegraleseco.jpg?alt=media&token=586c03c5-17dd-41f2-b2b0-5282ed2bf3b8", 11.17, 3.35,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasestrella.jpg?alt=media&token=38e9dc5c-d7f4-4b89-b31f-50395e5906ee", 0.95, 1.18,"prueba"))
                        App.obtenerDB().productoDao().save(Producto( "galletas oreo original", "mondelez", "pack galletas oreo 154 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasoreo.jpg?alt=media&token=8dbc8715-eb7e-4984-a8bf-91fc25ff1944", 6.80, 2.99,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galletas de chocolate", "carrefour", "Galletas chocolate con leche Digestive Carrefour 300 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletaschocolate.jpg?alt=media&token=aa6773d4-a8c7-4e40-af62-114059812902", 2.67, 0.80,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("Galleta flakes choco", "cuetara", "Galleta flakes choco cuetara 550g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletachocoflakes.jpg?alt=media&token=1cd8d80d-78f4-43d5-9976-534783568433", 4.45, 2.45,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galleta principe mini", "principe", "galleta de chocolate 160 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasprincipemini.jpg?alt=media&token=2d6df324-82b7-4e35-aa50-d8ab87912398", 9.06, 1.45,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galleta chips ahoy", "chips ahoy", "irresistibles con chocolate 125 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/chipsahoy.jpg?alt=media&token=7d0cfd34-507c-4570-87ba-a4886596710c", 0.70, 1.18,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galletas con naranja", "flora", "galletas de cereales 160 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletanaranja.jpg?alt=media&token=12782671-ad35-47b5-9ac7-5b96b8038b94", 0.45, 1.65,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("Galletas rellena cacao", "nocilla", "Galletas rellena con crema de cacao Nocilla 120 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasnocilla.jpg?alt=media&token=30bf5b13-b3cd-4227-a4d9-e3f7e0f99315", 0.85, 2.74,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galletas de caf??", "reglero", "caf?? regelo colombianos 260 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascafe.jpg?alt=media&token=c44e0e86-aebc-4c1d-b732-c9148125edf8", 0.95, 3.52,"prueba"))
                        App.obtenerDB().productoDao().save(Producto("galletas bio", "gull??n", "bio organic digestive 270 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasbio.jpg?alt=media&token=59a514bd-595f-40d1-988a-10aaa10b3624", 0.89, 3.29,"prueba"))

                         App.obtenerDB().productoDao().save(Producto("Azafr??n en hebras", "CARMENCITA", "Azafr??n en hebras Carmencita 0,375 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/azafr%C3%A1n.jpg?alt=media&token=12a87307-2752-4d8e-9497-26fe40f744cf", 72.90, 2.90,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Levadura", "ROYAL", "Levadura Royal pack de 6 sobres de 16 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/levadura.jpg?alt=media&token=733b7f9e-f9a4-4dc3-b149-6bb54fc5b0bc", 23.25, 2.29,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Arroz", "SOS", "Arroz redondo Sos 1 kg.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/arrozsos.jpg?alt=media&token=646a9edc-ccaa-4917-a1b7-3394b2440d5b", 1.55, 1.55,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Alubia blanca", "LUENGO", "Alubia blanca categor??a extra Luengo 1 kg.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/alubialuengo.jpg?alt=media&token=1ff3aa61-a114-437c-9d95-3e7032d7f5bc", 2.75, 2.75,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Lenteja pardina", "LUENGO", "Lenteja pardina categor??a extra Luengo 1 kg.x", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lentejaluengo.jpg?alt=media&token=6d822201-4eac-40da-a3d8-68e2c99be8e9", 3.05, 3.05,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Aceite de oliva", "DCOOP", "Aceite de oliva virgen extra Dcoop garrafa 5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aceiteoliva.jpg?alt=media&token=fe888db9-95c0-4878-847a-f31186117a37", 2.09, 10.45,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Mayonesa", "HELLMANN'S", "Mayonesa tarro 650 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/mayonesa.jpg?alt=media&token=a2d9a3ab-4aa6-40c0-8697-b2ebcf5872c8", 3.06, 1.99,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Macarrones", "GALLO", "Macarrones plumas n??6 750 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/macarr%C3%B3ngallo.jpg?alt=media&token=d64a1d6f-9047-4eee-a44c-9790981a4053", 1.69, 1.27,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Vinagre bals??mico", "CARREFOUR", "Vinagre bals??mico de m??dena Carrefour 250 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/vinagrevalsamico.jpg?alt=media&token=c0bee94f-9975-4548-9a8a-e0730528b963", 4.60, 1.15,"alimentacion"))
                         App.obtenerDB().productoDao().save(Producto("Berengena", "VERDURAS", "Berenjena a granel 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berengena.jpg?alt=media&token=a21d6c36-4ba3-4ed8-aece-27a16729c623", 3.83, 1.15,"alimentacion"))

                         App.obtenerDB().productoDao().save(Producto("Coca Cola zero", "COCACOLA", "Coca Cola zero az??car pack 4 botellas 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cocacolazero.jpg?alt=media&token=cd68289a-f816-47af-a670-ce9011ff3979", 0.84, 6.76,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Aquarius sabor lim??n zero", "ACUARIUSZERO", "Aquarius sabor lim??n zero botella 1.5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/acuariolimon.jpg?alt=media&token=e33445d2-d39f-4287-9b07-5ff1ea5d726b", 1.15, 1.72,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Vino Semidulce", "DIAMANTE", "Diamante Semidulce Sin Crianza", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/diamante.jpg?alt=media&token=4556e200-a79c-4b0c-ad13-ce7ba957cda8", 3.99, 3.99,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Fanta naranja", "COCACOLA", "Refresco de naranja Fanta con gas pack de 2 botellas de 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fantanaranja.jpg?alt=media&token=e9c2b5e9-387e-4d81-a694-1dda9465b705", 0.57, 2.28,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Vino Blanco", "FOUR LINES", "Four Lines Blanco 2020", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fourlineblanco.jpg?alt=media&token=9f40bd08-5561-43a7-b249-9393f14c538e", 5.50, 5.50,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Gaseosa", "LA CASERA", "Gaseosa La Casera cero calor??as pack de 4 botellas de 1,5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/gaseosa.jpg?alt=media&token=ff78df50-d9af-40e3-b7b0-bb42cbd67708", 0.55, 3.30,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Whisky", "JOHNNIE WALHER", "Johnnie Walker Double Black Whisky", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/joniwalker.jpg?alt=media&token=4d645ebf-a41a-425a-9a05-aefae7a311d3", 39.86, 27.90,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Vino Rioja", "LUIS CA??AS ", "Luis Ca??as Tinto 2017", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/riojaluisca%C3%B1a.jpg?alt=media&token=4ac12d92-ebbc-488b-a10f-ea4963bfe8c3", 10.50, 10.50,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("T??nica Schweppes zero", "SCHWEPPES", "T??nica Schweppes zero lata 25 cl.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/tonicalatazero.jpg?alt=media&token=804ecf7b-5400-4b73-a51b-648214e05603", 2.88, 0.72,"bebida"))
                         App.obtenerDB().productoDao().save(Producto("Vino frizzante", "YLLERA", "Yllera 5.5 Verdejo Frizzante", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yllera.jpg?alt=media&token=4e54030a-fa49-4f4f-9737-9e2d1bd76967", 5.69, 5.69,"bebida"))

                         App.obtenerDB().productoDao().save(Producto("Detergente ropa", "ARIEL", "Detergente l??quido Alpine Ariel 50 lavados.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/ariel.jpg?alt=media&token=a0b4ad6b-266c-403e-a2af-0d5eb1fd5f16", 0.28, 13.95,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Limpiador desinfectante", "SANYTOL", "Limpiador desinfectante multiusos sin lej??a Sanytol 750 ml", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/desinfectante.jpg?alt=media&token=f524421b-65b0-414e-8f2e-9f537d04d232", 3.13, 2.35,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Limpiador de ba??o", "DON LIMPIO", "Limpiador de ba??o Don Limpio 1,5 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/donlimpio.jpg?alt=media&token=94c6dce2-6491-4367-b55c-4e045465b206", 1.50, 2.25,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Lavavajillas a mano", "FAIRY", "Lavavajillas a mano Fairy Ultra Poder 650 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/fairy.jpg?alt=media&token=431d8ffc-9c08-453c-b5a7-040169e3b644", 4.62, 3.00,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Lej??a", "CONEJO", "Lej??a acci??n total Conejo 2 l.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lejia.jpg?alt=media&token=600dd6f4-2047-4e77-9dc3-291f48d3964a", 0.89, 1.79,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Caja de pa??uelos", "KLEENEX", "Caja de pa??uelos Family Kleenex 140 ud.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pa%C3%B1uelos.jpg?alt=media&token=cfcf2216-eafc-4af8-ba29-2f65528c5974", 0.01, 1.80,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Papel higi??nico", "SCOTTEX", "Papel higi??nico acolchado toque de seda Scottex 24 rollos.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/papelhigienico.jpg?alt=media&token=f47d62b4-9065-4a1c-b88f-bec5036ba4c7", 0.44, 10.50,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Quitagrasas", "KH-7 ", "Quitagrasas original KH-7 recambio 750 ml.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/quitagrasas.jpg?alt=media&token=535a02bd-ae21-4a9a-b1fb-4b15afa772c8", 3.59, 2.69,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Servilletas", "RENOVA", "Set de Servilletas 1 capa de Celulosa RENOVA 200 200pz - Blancas", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/servilletas.jpg?alt=media&token=646767a5-1403-4492-8554-f119066a659a", 0.01, 0.92,"drogueria"))
                         App.obtenerDB().productoDao().save(Producto("Suavizante concentrado", "FLOR", "Suavizante concentrado azul Flor 72 lavados.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/suavizante.jpg?alt=media&token=f4fc4fb7-06a3-43a6-a6cf-6b0f6b717fe9", 0.05, 3.94,"drogueria"))

                         App.obtenerDB().productoDao().save(Producto("Mango", "FRUTA", "Mango nacional a granel 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/mango.jpg?alt=media&token=821eab35-bcb4-4c2b-9a85-9ba1844e2da8", 1.12, 2.25,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Kiwi", "ZESPRI", "Kiwi Zespri 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/kiwizespri.jpg?alt=media&token=552202bb-c089-49c0-80b1-341ad96bb24e", 3.99, 3.99,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Pi??a", "MONTE", "Pi??a del Monte premium pieza 1,5 Kg aprox ", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pi%C3%B1a.jpg?alt=media&token=f68691c6-0767-4b51-83f0-ea1cebd39c35", 1.49, 2.23,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Calabac??n", "VERDURA", "Calabac??n la despensa a granel 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabacin.jpg?alt=media&token=58a4e297-1f90-43a4-84fc-132e7fa0205e", 1.19, 1.19,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Calabaza sepallo", "VERDURA", "Calabaza sepallo a granel 1,5 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabaza.jpg?alt=media&token=795df4f4-56e2-47c7-9f5b-12c5c9dc9469", 1.25, 1.87,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Cebolla dulce selecci??n", "FUENTE", "Cebolla dulce selecci??n 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cebollafuente.jpg?alt=media&token=03f52d25-fc15-43cd-a773-5c4541f6c230", 1.99, 1.99,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Aguacate", "FRUTA", "Aguacate de origen nacional 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aguacate.jpg?alt=media&token=20e670ad-5ea0-4422-a177-a5bd92da08b8", 4.00, 2.00,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Esp??rrago verde", "VERDURAS", "Esp??rrago verde manojo de 300 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/esparrago.jpg?alt=media&token=a4b2adda-7a72-49c4-8ffe-7dec2d1f6c32", 3.83, 1.15,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Berengena", "VERDURAS", "Berenjena a granel 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berengena.jpg?alt=media&token=a21d6c36-4ba3-4ed8-aece-27a16729c623", 3.83, 1.15,"fruta"))
                         App.obtenerDB().productoDao().save(Producto("Pl??tano", "COPLACA", "Pl??tano de Canarias 500 g arpox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/platano.jpg?alt=media&token=90896c21-7f5d-4c9b-ab43-7683cb059e74", 3.95, 2.00,"fruta"))


                         App.obtenerDB().productoDao().save(Producto("Preparado de carne picada", "AVINATUR", "Preparado de carne picada de vacuno 2x450 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/carnepicada.jpg?alt=media&token=585dd623-59fa-4d10-bad8-8bed90db2374", 5.21, 4.69,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Lomo de cerdo adobado", "PAVOFRIO", "Lomo de cerdo adobado fileteado 650 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lomoadobado.jpg?alt=media&token=2b5fc3a1-5c12-43fc-92e9-df382e6e2e7e", 6.50, 4.22,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Pechuga de pollo", "PAVISO", "Pechuga de pollo certificado en filetes 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pechugapollo.jpg?alt=media&token=52d951e2-df39-4c9e-8777-2d458aa47bad", 8.29, 4.14,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Entrecot de vacuno", "PAVISO", "Entrecot de vacuno para la piedra 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/entrcotternera.jpg?alt=media&token=4c5ac398-d85c-4f06-84df-b5845c63ba1a", 10.95, 5.45,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Trozo lomo cerdo ", "AVINATUR", "Trozo de lomo de cerdo 1,2 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/trozolomocerdo.jpg?alt=media&token=b6145be6-220b-4bc1-a0eb-a36be36cfb76", 3.95, 4.74,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Pechuga de pollo campero", "PAVISO", "Pechuga de pollo campero fileteada 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pechugacampero.jpg?alt=media&token=2a68006a-7f1e-4244-b336-8bb84436ce64", 13.99, 6.99,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Hamburguesa a??ojo", "AVINATUR", "Hamburguesa a??ojo 6x90 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/hamburguesaa%C3%B1ojo.jpg?alt=media&token=7e80d3c2-f77e-4714-8d3c-0e3290537243", 6.28, 3.39,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Chuleta aguja de cerdo ", "AVINATUR", "Chuleta aguja de cerdo 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/chuletacerdo.jpg?alt=media&token=085c80e3-1215-49b8-bec3-5d01f399c0ac", 3.99, 3.99,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Solomillo vacuno", "CANALVISO", "solomillo vacuno 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/solomillovacuno.jpg?alt=media&token=be53cfa4-3993-4ea5-b67f-5df2d19ad14f", 19.95, 9.97,"carne"))
                         App.obtenerDB().productoDao().save(Producto("Jamoncitos de pollo", "AVINATUR", "Jamoncitos de pollo 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/jamoncitospollo.jpg?alt=media&token=19b0bcb4-6948-4d7c-9bb8-176c7321f939", 3.45, 3.45,"carne"))

                         App.obtenerDB().productoDao().save(Producto("Yogur b??fidus", "DANONE", "Yogur b??fidus desnatado edulcorado natural Danone Activia pack de 8 unidades de 120 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurbifidus.jpg?alt=media&token=83ad70d6-6b03-4500-a470-ba124b5eabb4", 3.06, 3.06,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur con bolitas", "NESTL??", "Yogur con bolitas cubiertas de chocolate Mix-in Nestl?? Kit Kat pack de 2 unidades de 115 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurbolitas.jpg?alt=media&token=604ad726-f605-4cd4-a273-809a67e2df25", 6.52, 1.50,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur leche de cabra", "GOSHUA", "Yogur natural de leche de cabra Goshua 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurcabra.jpg?alt=media&token=d0959b57-a5fc-4978-9942-71363c60a1b6", 8.76, 2.19,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur con fresa", "NESTL??", "Yogur con fresa Nestl?? La Lechera sin gluten pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurfresa.jpg?alt=media&token=cc3dacd3-0185-41f1-adb8-504e6138593a", 4.56, 1.14,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur de fresa con grageas", "NESTL??", "Yogur de fresa con grageas de chocolate Nestl?? Smarties pack de 2 unidades de 128 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurgragea.jpg?alt=media&token=6dc32825-27f1-4a2d-a3ad-96de40b96dd5", 5.86, 1.50,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur agrupado", "DANONE", "Yogur de fresa, macedonia, galleta y fresa-pl??tano Danone sin gluten pack de 12 unidades", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmacedonia.jpg?alt=media&token=7fa9dd8b-19ed-478b-b713-ab6c70e080a5", 1.93, 2.78,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur de mango", "PASTORET", "Yogur de mango ecol??gico Pastoret 135 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmango.jpg?alt=media&token=39c4b686-82e7-48ea-9571-a5031cce5626", 10.52, 1.42,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yoyur melocot??n", "LALECHERA", "Yogur con melocot??n Nestl?? La Lechera sin gluten pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yogurmelocoton.jpg?alt=media&token=b751f70a-3555-4744-8609-f2763acb9ca7", 4.56, 1.14,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur griego ", "DANONE", "Yogur griego con stracciatella Danone Oikos sin gluten pack de 4 unidades de 110 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yoguroikos.jpg?alt=media&token=fbb64724-12ed-483e-aeaf-84dc995ce71d", 4.82, 2.12,"lacteos"))
                         App.obtenerDB().productoDao().save(Producto("Yogur con leche de oveja", "GOSHUA", "Yogur con leche de oveja natural Goshua pack de 2 unidades de 125 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/yoguroveja.jpg?alt=media&token=45c60054-4221-4aa1-95f3-760b8f3a573a", 7.36, 1.84,"lacteos"))

                         App.obtenerDB().productoDao().save(Producto("Aguacate", "FRUTA", "Aguacate de origen nacional 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/aguacate.jpg?alt=media&token=20e670ad-5ea0-4422-a177-a5bd92da08b8", 4.00, 2.00,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("Calabac??n", "FRUTA", "Calabac??n nacional a granel 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/calabacin.jpg?alt=media&token=58a4e297-1f90-43a4-84fc-132e7fa0205e", 1.19, 1.19,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("Cebolla dulce selecci??n", "FUENTE", "Cebolla dulce selecci??n 1 Kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/cebollafuente.jpg?alt=media&token=03f52d25-fc15-43cd-a773-5c4541f6c230", 1.99, 1.99,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("galletas cookies", "gullon", "galletas de trigo con chocolate 250 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletascookies.jpg?alt=media&token=eb2af291-99ce-4767-a9a7-245cc010ea89", 0.85, 1.85,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("estrellas de chocolate", "lu principe", "estrella de galletas de chocolate 150 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasestrella.jpg?alt=media&token=38e9dc5c-d7f4-4b89-b31f-50395e5906ee", 0.95, 1.18,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("galletas oreo original", "mondelez", "pack galletas oreo 154 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletasoreo.jpg?alt=media&token=8dbc8715-eb7e-4984-a8bf-91fc25ff1944", 6.80, 2.99,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("galletas de chocolate", "carrefour", "Galletas chocolate con leche Digestive Carrefour 300 g.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletaschocolate.jpg?alt=media&token=aa6773d4-a8c7-4e40-af62-114059812902", 2.67, 0.80,"novedad"))
                         App.obtenerDB().productoDao().save(Producto("Galleta flakes choco", "cuetara", "Galleta flakes choco cuetara 550g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/galletachocoflakes.jpg?alt=media&token=1cd8d80d-78f4-43d5-9976-534783568433", 4.45, 2.45,"novedad"))

                         App.obtenerDB().productoDao().save(Producto("Pan picos", "PANADERA", "Pan de picos la despensa 1 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpicos.jpg?alt=media&token=ed30c493-6259-453a-8f42-66d1ef0fa8d6", 1.68, 0.57,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Pan de pueblo", "PANADERA", "Pan de pueblo sin aditivos 800 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpueblo.jpg?alt=media&token=949cd4bd-fc5e-4bba-bc33-d3b5ce8100d0", 1.44, 1.15,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Pan pay??s", "PANADERA", "Pan pay??s grande Hecho aqu?? Carrefour 800 gx", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/panpayes.jpg?alt=media&token=0aaa47a2-4973-4d84-9a97-de0976014af3", 2.55, 2.55,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Pan anta??o", "PANADERA", "Pan de anta??o Carrefour 1 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pananta%C3%B1o.jpg?alt=media&token=1704a70a-fa6b-42a4-aa46-d2b00e4c9c96", 3.62, 1.45,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Pan gallego ", "PANADERA", "Pan gallego de cereales sin lactosa 70 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pangallego.jpg?alt=media&token=bed68339-f2a6-4768-9efa-ff707525fd24", 4.14, 0.29,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Berlina bomb??n", "PANADERA", "Berlinas bomb??n 4 ud", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/berlinabombon.jpg?alt=media&token=08e22e45-04de-4870-beff-6f8c3d6bc1f0", 5.37, 1.15,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Bretzel de chocolate", "PANADERA", "Bretzel de chocolate y mantequilla 100 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/brezelchocolate.jpg?alt=media&token=da584ed4-06ea-4150-b75f-ac68f475950c", 8.50, 0.85,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Magdalena", "PANADERA", "Magdalenas caseras 420 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/magdalena.jpg?alt=media&token=f08a96a7-382c-43a3-a66d-2ef4f79212ab", 7.12, 2.99,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Pastel manzana", "PANADERA", "Pastel de manzana 125 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pastelmanzana.jpg?alt=media&token=c4913231-847c-43b6-811b-d40e9af2e0f1", 6.80, 0.85,"pan"))
                         App.obtenerDB().productoDao().save(Producto("Bizcocho", "PANADERA", "Bizcocho casero 500 g", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/bizcocho.jpg?alt=media&token=3c98482b-1d6f-430d-82ad-61bed4aea04c", 6.00, 3.00,"pan"))

                         App.obtenerDB().productoDao().save(Producto("Lubina", "PESCADO", "Lubina de raci??n 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lubina.jpg?alt=media&token=16ec7cf7-79ed-43b4-800f-35d8c879af54", 6.45, 3.22,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Dorada", "PESCADO", "Dorada de raci??n 500 g aprox.", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/dorada.jpg?alt=media&token=94598e24-cfa3-4bed-8c76-8db6a04fbee7", 7.45, 3.75,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Lomo At??n", "PESCADO", "Lomo de at??n 300 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lomoatun.jpg?alt=media&token=e825a791-a613-484f-bbdc-b4787e770f58", 10.90, 3.27,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Lenguado", "PESCADO", "Lenguado raci??n 125 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/lenguado.jpg?alt=media&token=0bc6447b-ac4b-495f-9c75-b52eaab606db", 11.90, 1.49,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Gallo", "PESCADO", "Gallo raci??n 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/gallo.jpg?alt=media&token=6829d449-7d33-4805-a8cd-b3e78ece3f64", 7.99, 3.99,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Boquerones", "PESCADO", "Boquerones 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/boquerones.jpg?alt=media&token=4caeaef6-4921-435c-a797-a79d45fa2d5d", 3.90, 1.95,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Bacaladilla", "PESCADO'S", "Bacaladilla 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/bacaladilla.jpg?alt=media&token=c96528dd-f177-473a-994b-5b9cbb5c5dc9", 1.95, 0.99,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Trucha", "PESCADO", "Trucha asalmonada C??rculo de Calidad 500 g aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/trucha.jpg?alt=media&token=38b21256-5908-41a9-8e60-980f3b271f07", 6.25, 3.12,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Salm??n", "PESCADO", "Salm??n Calidad y Origen Carrefour 1 ud de 3 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/salmon.jpg?alt=media&token=a7a2d18b-7635-4ffd-add2-6da3e1b7ac52", 8.75, 21.87,"pescado"))
                         App.obtenerDB().productoDao().save(Producto("Pescadilla", "PESCADO", "Pescadilla fina 1 kg aprox", "https://firebasestorage.googleapis.com/v0/b/la-despensa-de-mi-casa.appspot.com/o/pescadilla.jpg?alt=media&token=52ffbc06-5484-4d6c-a405-85e0f39647e9", 5.90, 5.90,"pescado"))
                        
                        
                    }
                }
            }


        }

        /* private fun insertProductos(): List<Producto> {

             val productos = mutableListOf<Producto>()


         }*/


    }


}

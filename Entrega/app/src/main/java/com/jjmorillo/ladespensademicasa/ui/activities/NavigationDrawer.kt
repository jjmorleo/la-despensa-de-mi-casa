package com.jjmorillo.ladespensademicasa.ui.activities

import android.content.Intent
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.ActivityNavigationDrawerBinding
import com.jjmorillo.ladespensademicasa.databinding.AppBarMainBinding
import com.jjmorillo.ladespensademicasa.viewModels.CarritoViewModel

class NavigationDrawer : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationDrawerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNavigationDrawerBinding.inflate(layoutInflater)
        val view = binding.root
        auth = Firebase.auth

        setContentView(view)

        val coordinatorBinding= AppBarMainBinding.bind(binding.coordinatorLayout.root)

        val toolbar: Toolbar = coordinatorBinding.toolbar
        setSupportActionBar(toolbar)


        //ESTO SERIA PARA LA FUNCIONALIDAD DEL BOTON FLOTANTE
        /*val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
             R.id.nav_frutasVerdurasFragment, R.id.nav_carnesFragment, R.id.nav_pescadosFragment, R.id.nav_panBolleriaFragment, R.id.nav_alimentacionFragment, R.id.nav_bebidasFragment, R.id.nav_lacteosFragment, R.id.nav_drogueriaLimpiezaFragment, R.id.productosFragment2
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)


        //Para hacer logout en el Menú action bar en los tres puntitos
        /*binding.navView.menu.findItem(R.id.action_logout).setOnMenuItemClickListener{
            //auth.signOut()
            //cerrarSesion()
        }*/
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_logout->{
                auth.signOut()
                val intent= Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }

        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
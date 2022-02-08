package com.strixapps.finalmvvm.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat
import com.strixapps.finalmvvm.common.BaseActivity
import com.strixapps.finalmvvm.common.NavData
import com.strixapps.finalmvvm.databinding.ActivityMainBinding
import com.strixapps.finalmvvm.ui.main.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.strixapps.finalmvvm.R

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val vm by viewModel<HomeViewModel>()

    private val vmMain by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.appBarMain.toolbar)

        observeData(vmMain.obsShowFab, ::onObserveFab)
        observeData(vmMain.obsNavigate, ::onObserveNav)

        binding.appBarMain.fab.setOnClickListener {
            vm.onActionDownloadClicked()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


//        navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> navController.navigate(R.id.nav_home)
//                R.id.nav_gallery -> navController.navigate(R.id.nav_gallery)
//                R.id.nav_slideshow -> navController.navigate(R.id.nav_slideshow)
//            }
//            true
//        }

    private fun onObserveNav(navData: NavData?) {
        navData?.also {

        }?:also {
            if(!findNavController(R.id.nav_view).navigateUp())
                finish()
        }
    }

    private fun onObserveFab(show:Boolean){
        binding.appBarMain.fab.visibility = if(show) View.VISIBLE else View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showLoading() {
        binding.flMainLoading.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding.flMainLoading.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
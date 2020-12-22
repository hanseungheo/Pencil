package com.hanseungheon.pencil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hanseungheon.pencil.databinding.ActivityBottomNavBinding

class BottomNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_bottom_nav )
        binding.activity=this

        loadFragment(BlankFragment())
        binding.nav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return loadFragment(when (item.itemId) {
            R.id.nav_settings -> BlankFragment()
            R.id.nav_down -> BlankFragment2()
            else -> BlankFragment()
        })
    }
    fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit()
            return true
        }
        return false
    }
}
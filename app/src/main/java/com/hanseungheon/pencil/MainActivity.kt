package com.hanseungheon.pencil

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Geocoder
import android.location.LocationManager
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hanseungheon.pencil.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recorder: MediaRecorder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity=this
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val item= arrayListOf("사과", "바나나")
        val adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
        binding.listView.adapter=adapter
        binding.button.setOnClickListener {
            adapter.add("키위")
            adapter.notifyDataSetChanged()
        }

        val person=Person("한승헌", 0, true)
        Log.d(person.name, person.eat("밥").toString())
        Log.d(person.name, person.eat("볶음밥").toString())
        person.walk()
        person.think("나는 한승헌이다")
        val student=Student("한승헌", 0, true,20909)
        Log.d(student.studentName, student.eat("밥").toString())
        student.walk()
        student.think("나는 한승헌이다")
        student.study("정보")






    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                Toast.makeText(applicationContext, "글자", Toast.LENGTH_LONG).show()
            }
            R.id.menu_settings ->{
                val intent=Intent(applicationContext, BottomNavActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
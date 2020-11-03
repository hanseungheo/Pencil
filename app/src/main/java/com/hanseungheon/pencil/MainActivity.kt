package com.hanseungheon.pencil

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Geocoder
import android.location.LocationManager
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hanseungheon.pencil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recorder: MediaRecorder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity=this
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO),0)

        }
        var isRecording=false

        var filePath = ""


        binding.record.setOnClickListener {
            if (!isRecording) {
                filePath = externalMediaDirs[0].absolutePath + "/${System.currentTimeMillis()}.mp3"
                recorder = MediaRecorder()
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
                recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                recorder.setAudioSamplingRate(44100)
                recorder.setAudioEncodingBitRate(96000)
                recorder.setOutputFile(filePath)
                try {
                    recorder.prepare()
                } catch(e: Exception) {
                    e.printStackTrace()
                }


                recorder.start()
                binding.record.text = "RECORDING"
                isRecording = true
            } else {
                recorder.stop()
                binding.record.text = "RECORD"
                isRecording = false
                Toast.makeText(this, filePath, Toast.LENGTH_SHORT).show()
            }
        }
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),0)
        }
        binding.gps.setOnClickListener {
            val lm=getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val provider = lm.getBestProvider(Criteria(), true) ?: LocationManager.GPS_PROVIDER
            val location = lm.getLastKnownLocation(provider)

            val lat = location?.latitude ?: 0.0
            val lon = location?.longitude ?: 0.0

            val geocoder = Geocoder(this)
            val data = geocoder.getFromLocation(lat, lon, 1).first()

            Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()


        }
    }

}
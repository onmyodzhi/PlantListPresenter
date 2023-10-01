package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(R.drawable.plant_1,
        R.drawable.plant_2,
        R.drawable.plant_3,
        R.drawable.plant_4,
        R.drawable.plant_5)
    private var temp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter

            button.setOnClickListener {
                val plantImageName = resources.getResourceEntryName(R.drawable.plant_1)
                val plant = Plant(imageIdList[temp], plantImageName)
                temp++
                if (temp >= imageIdList.size){
                    temp = 0
                }

                adapter.addPlant(plant)

            }
        }
    }

}
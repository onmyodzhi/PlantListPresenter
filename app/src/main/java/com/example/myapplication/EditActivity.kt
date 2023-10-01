package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityEditAcrivityBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditAcrivityBinding
    private var imageId = R.drawable.plant_1
    private var indexImage = 0
    private val imageIdList = listOf(
        R.drawable.plant_1,
        R.drawable.plant_2,
        R.drawable.plant_3,
        R.drawable.plant_4,
        R.drawable.plant_5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAcrivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()

    }

    private fun initButtons() = with(binding){
        nextImage.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1){
                indexImage = 0
            }
            imageId = imageIdList.get(indexImage)
            plantsImage.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }


}
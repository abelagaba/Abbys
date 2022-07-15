package com.agaba.abbys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agaba.abbys.databinding.ActivityFoodDetailsBinding

class FoodDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        }
    }
}
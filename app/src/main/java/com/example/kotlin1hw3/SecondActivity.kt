package com.example.kotlin1hw3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1hw3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getIntegerArrayListExtra("image")
        adapter = MainAdapter(list!!, null)
        binding.rvImages.adapter = adapter
    }
}
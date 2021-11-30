package com.example.kotlin1hw3

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.core.content.ContextCompat
import com.example.kotlin1hw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MainAdapter

    private var list = arrayListOf<Int>()
    private var secondList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createList()
        initRv()
        send()
    }

    private fun send() {
        binding.btnSend.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("image", secondList)
            startActivity(intent)
        }
    }

    private fun createList() : ArrayList<Int> {
        for (i in 1..40){
            list.add(R.drawable.img)
            list.add(R.drawable.img_second)
            list.add(R.drawable.img_third_sheep)
        }
        return list
    }

    private fun initRv() {
        adapter = MainAdapter(createList(), object : MainAdapter.OnItemClick{
            override fun onClick(image: Int) {
                secondList.add(image)
            }

            override fun onDeleteClick(image: Int) {
                secondList.remove(image)
            }

        })
        binding.rvImages.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
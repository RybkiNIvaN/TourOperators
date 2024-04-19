package com.example.touroperators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.touroperators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = OperatorAdapter()
    lateinit var recyclerView: RecyclerView
    private val imageIdList = listOf(
        R.drawable.op1,
        R.drawable.op2,
        R.drawable.op3,
        R.drawable.op4,
        R.drawable.op5
    )
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                if (counter > 4) counter = 0
                val operator = Operator(imageIdList[counter], "Operator $counter")
                adapter.addOperator(operator)
                counter++
            }
        }
    }
}
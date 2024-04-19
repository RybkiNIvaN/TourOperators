package com.example.touroperators

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.touroperators.databinding.ActivityMainBinding
import com.example.touroperators.db.Db

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = OperatorAdapter(this)
    lateinit var recyclerView: RecyclerView

    private lateinit var db: Db

    private val imageIdList = listOf(
        R.drawable.logo,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Db.getDatabase(this)

        binding.rcView.adapter = adapter

        binding.buttonAdd.setOnClickListener{
            val intent = Intent(this, AddOperatorActivity::class.java)
            startActivity(intent)
        }

        adapter.setList(initAdadpter())
    }

    private fun initAdadpter(): ArrayList<Operator> {
        val operatorList = arrayListOf<Operator>()

        db.operatorDao().getOperators().asLiveData().observe(this) {
            for (operator in it) {
                adapter.addOperator(Operator(
                    operator.id,
                    imageIdList[0],
                    operator.name,
                    "Рейтинг: ${operator.rating}",
                    "Номер телефона: ${operator.phoneNumber}"))
            }
        }

        return operatorList
    }
}
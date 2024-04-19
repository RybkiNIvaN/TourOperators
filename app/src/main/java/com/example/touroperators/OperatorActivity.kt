package com.example.touroperators

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.touroperators.databinding.ActivityOperatorBinding
import com.example.touroperators.db.Db

class OperatorActivity : AppCompatActivity() {

    private lateinit var db : Db
    private lateinit var binding : ActivityOperatorBinding
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOperatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Db.getDatabase(this)
        intent = getIntent()
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        Thread {
            val operator = db.operatorDao().getOperatorById(intent.getIntExtra("id", -1))

            binding.name.text = operator.name
            binding.rating.text = "Рейтинг: ${operator.rating}"
            binding.phoneValue.text = operator.phoneNumber

            binding.yearValue.text = "${operator.year} год"

            val places = operator.places.split(", ", ",")
            binding.loc.adapter = ArrayAdapter(this, R.layout.simple_list_item_activated_1, places)
        }.start()
    }

}
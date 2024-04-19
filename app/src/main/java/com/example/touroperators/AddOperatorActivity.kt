package com.example.touroperators

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.touroperators.DbModels.OperatorDb
import com.example.touroperators.databinding.ActivityAddOperatorBinding
import com.example.touroperators.db.Db

class AddOperatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddOperatorBinding
    private lateinit var db : Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOperatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Db.getDatabase(this)

        binding.button.setOnClickListener {

            val operator = OperatorDb(
                null,
                binding.name.text.toString(),
                binding.rating.text.toString().toDouble(),
                binding.yearCreate.text.toString(),
                binding.phone.text.toString(),
                binding.places.text.toString(),
            )

            Thread {
                db.operatorDao().addOperator(operator)
            }.start()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
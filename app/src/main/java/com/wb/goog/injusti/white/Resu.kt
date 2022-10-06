package com.wb.goog.injusti.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wb.goog.injusti.databinding.ActivityResuBinding


class Resu : AppCompatActivity() {
    lateinit var binding: ActivityResuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scoret.text=getIntent().getStringExtra("key")
        binding.start.setOnClickListener {
            val intent= Intent(this@Resu, GameGa::class.java)
            startActivity(intent)
        }
        binding.rules.setOnClickListener {
            val intent= Intent(this@Resu, Rules::class.java)
            startActivity(intent)
        }
    }
}
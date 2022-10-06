package com.wb.goog.injusti.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wb.goog.injusti.R


class Rules : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
        val men=findViewById<Button>(R.id.menu)
        men.setOnClickListener {
            val intent= Intent(this@Rules, Resu::class.java)
            startActivity(intent)
        }
    }
}
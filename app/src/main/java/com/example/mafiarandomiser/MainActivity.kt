package com.example.mafiarandomiser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.start_button)
    }

    fun onStartClick(view: View) {
        val intent = Intent(this, SetupActivity::class.java)
        startActivity(intent)
    }
}

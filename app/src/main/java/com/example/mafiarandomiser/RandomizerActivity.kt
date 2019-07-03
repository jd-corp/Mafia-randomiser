package com.example.mafiarandomiser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RandomizerActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        textView = findViewById(R.id.textView)

        var map = intent.getSerializableExtra("setupData") as HashMap<String, Int>
        textView.text = map.keys.toString() + map.values.toString()
    }
}

package com.example.mafiarandomiser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.Integer.parseInt

class SetupActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, Int>
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        button = findViewById(R.id.submit_button)
    }

    fun onSubmit(view: View) {
        var key: String = findViewById<EditText>(R.id.inputRole1).text.toString()
        var value: Int = parseInt(findViewById<EditText>(R.id.inputNum1).text.toString())
        map[key] = value

        Log.v("WTFISDIS", "I passed it")

        var intent = Intent(this, RandomizerActivity::class.java)
        intent.putExtra("setupData", map)
        startActivity(intent)
    }
}

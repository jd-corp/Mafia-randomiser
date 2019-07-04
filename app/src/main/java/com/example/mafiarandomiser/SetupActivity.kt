package com.example.mafiarandomiser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.Serializable
import java.lang.Integer.parseInt

class SetupActivity : AppCompatActivity() {

    lateinit var list: MutableList<Role>
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        button = findViewById(R.id.submit_button)
    }

    fun onSubmit(view: View) {
        var role: String = findViewById<EditText>(R.id.inputRole1).text.toString()
        var num: Int = parseInt(findViewById<EditText>(R.id.inputNum1).text.toString())
        list = mutableListOf(Role(role, num))

        var intent = Intent(this, RandomizerActivity::class.java)
        intent.putExtra("setupData", list.toTypedArray())
        startActivity(intent)
    }
}

data class Role(var roleName: String = "none", var numberOf: Int = 0) : Serializable
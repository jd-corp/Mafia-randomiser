package com.example.mafiarandomiser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random

class RandomizerActivity : AppCompatActivity() {

    lateinit var debugText: TextView
    lateinit var randomizedRoleText: TextView
    lateinit var randomizeButton: Button
    lateinit var array: MutableList<Role>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        debugText = findViewById(R.id.debugText)
        randomizedRoleText = findViewById(R.id.randomizedRoleText)
        randomizeButton = findViewById(R.id.randomizeButton)

        array = (intent.getSerializableExtra("setupData") as Array<Role>).toMutableList()
        Log.d("simple", array[0].roleName + array[0].numberOf)
        debugText.text = array[0].roleName + array[0].numberOf
    }

    fun onRandomize(view: View) {
        var randomObj = Random()
        var index = if (array.size == 1) 0 else randomObj.nextInt(array.size - 1)
        var randomRole = array[index]

        array[index].numberOf -= 1
        randomizedRoleText.text = randomRole.roleName + randomRole.numberOf
        if (array[index].numberOf == 0) {
            array.removeAt(index)
        }
        if (array.isEmpty()) {
            randomizeButton.isClickable = false
        }
    }
}

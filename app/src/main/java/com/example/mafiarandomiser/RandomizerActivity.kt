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
    lateinit var itemList: ArrayList<RoleValues>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        debugText = findViewById(R.id.debugText)
        randomizedRoleText = findViewById(R.id.randomizedRoleText)
        randomizeButton = findViewById(R.id.randomizeButton)

        itemList = intent.getParcelableArrayListExtra("setupData")
        Log.d("simple", itemList[0].roleName)
        debugText.text = itemList[0].roleName + itemList[0].numberOf
    }

    fun onRandomize(view: View) {
        var randomObj = Random()
        var index = if (itemList.size == 1) 0 else randomObj.nextInt(itemList.size)
        Log.d("simple", index.toString())
        var randomRole = itemList[index]

        itemList[index].numberOf -= 1
        randomizedRoleText.text = randomRole.roleName + randomRole.numberOf
        if (itemList[index].numberOf == 0) {
            itemList.removeAt(index)
        }
        if (itemList.isEmpty()) {
            randomizeButton.isClickable = false
        }
    }
}

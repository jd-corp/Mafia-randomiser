package com.example.mafiarandomiser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class SetupActivity : AppCompatActivity() {
    lateinit var itemList: ArrayList<RoleInputs>
    lateinit var button: Button
    lateinit var listView: RecyclerView
    lateinit var listAdapter: RecyclerView.Adapter<*>
    lateinit var listLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        button = findViewById(R.id.submit_button)
        itemList = arrayListOf(RoleInputs(EditText(this), EditText(this)))
        itemList.add(RoleInputs(EditText(this), EditText(this)))

        listLayoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(itemList)
        listView = findViewById<RecyclerView>(R.id.list).apply {
            setHasFixedSize(false)
            layoutManager = listLayoutManager
            adapter = listAdapter
        }
    }

    fun onSubmit(view: View) {
        var intent = Intent(this, RandomizerActivity::class.java)
        intent.putParcelableArrayListExtra("setupData", retrieveData())
        startActivity(intent)
    }

    fun retrieveData(): ArrayList<RoleValues> {
        var temp: ArrayList<RoleValues> = arrayListOf()
        for (role in itemList) {
            Log.d("simple", role.roleName.text.toString() + role.numberOf.text.toString())
            temp.add(RoleValues(role.roleName.text.toString(), role.numberOf.text.toString().toInt()))
        }
        return temp
    }
}

data class RoleInputs(var roleName: EditText, var numberOf: EditText)
data class RoleValues(var roleName: String, var numberOf: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(roleName)
        parcel.writeInt(numberOf)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoleValues> {
        override fun createFromParcel(parcel: Parcel): RoleValues {
            return RoleValues(parcel)
        }

        override fun newArray(size: Int): Array<RoleValues?> {
            return arrayOfNulls(size)
        }
    }
}
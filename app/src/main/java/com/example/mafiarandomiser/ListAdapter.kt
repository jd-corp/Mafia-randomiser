package com.example.mafiarandomiser

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class ListAdapter(var itemList: ArrayList<RoleInputs>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var roleName: EditText = itemView.findViewById(R.id.inputRole1)
        var roleNum: EditText = itemView.findViewById(R.id.inputNum1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        var v = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false) as View
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, p1: Int) {
        holder.roleName.setText(itemList[p1].roleName.text.toString())
        holder.roleNum.setText(itemList[p1].numberOf.text.toString())

        val watch1 = Watcher1()
        val watch2 = Watcher2()
        watch1.updatePosition(holder.adapterPosition)
        watch2.updatePosition(holder.adapterPosition)
        holder.roleName.addTextChangedListener(watch1)
        holder.roleNum.addTextChangedListener(watch2)
    }

    private inner class Watcher1 : TextWatcher {

        var position = 0

        fun updatePosition(pos: Int) {
            position = pos
        }

        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            itemList[position].roleName.setText(s)
        }
    }

    private inner class Watcher2 : TextWatcher {

        var position = 0

        fun updatePosition(pos: Int) {
            position = pos
        }

        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            itemList[position].numberOf.setText(s)
        }

    }
}
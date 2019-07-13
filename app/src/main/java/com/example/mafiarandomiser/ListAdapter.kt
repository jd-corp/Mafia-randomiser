package com.example.mafiarandomiser

import android.support.v7.widget.RecyclerView
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
    }
}
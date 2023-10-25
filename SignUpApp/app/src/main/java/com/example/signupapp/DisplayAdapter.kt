package com.example.signupapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class DisplayAdapter(private val context: Context, private val map:MutableMap<String, String>): RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder>(){
    class DisplayViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
        val value : TextView = view.findViewById(R.id.display_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.display_item, parent,false)
        return DisplayViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return map.size
    }

    override fun onBindViewHolder(holder: DisplayViewHolder, position: Int) {
        val item = map.keys.elementAt(position)
        holder.title.text = item
        holder.value.text = map.get(item)
    }

}
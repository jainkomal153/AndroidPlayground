package com.example.signupapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainAdapter(private val context: Context, private val map:MutableMap<String, String>):RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    class MainViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val textView :TextView = view.findViewById(R.id.title)
        val inputTextField : TextInputEditText = view.findViewById(R.id.input_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return MainViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return map.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = map.keys.elementAt(position)
        holder.textView.text = item
        holder.inputTextField.id = position
        map.put(item, position.toString())
//        holder.imageView.setImageResource(item.imageResourceId)
    }

}
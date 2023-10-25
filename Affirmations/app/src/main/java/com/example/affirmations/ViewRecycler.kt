package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class ViewRecycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)

        val myDataset = Datasource().loadAffirmations()
        val itemAdapter = ItemAdapter(this, myDataset)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layout = intent?.extras?.getString("layout").toString()

        if(layout == "linear"){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        recyclerView.adapter = itemAdapter
        title = "${layout} Layout View"
    }
}
package com.example.jogodamemoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListarProfsActivity : AppCompatActivity() {
    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_profs)

        listView = findViewById<ListView>(R.id.list_view)

        //1
        val profList = Professor.getProfsFromFile("profs.json", this)

        val adapter = RecipeAdapter(this, profList)
        listView.adapter = adapter

    }
}

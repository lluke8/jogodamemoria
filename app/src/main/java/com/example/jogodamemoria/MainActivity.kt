package com.example.jogodamemoria

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnGame:Button
    private lateinit var btnListar:Button
    private lateinit var txtView: TextView
    private lateinit var btnSalvar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = PartidaDAO(this@MainActivity)
        this.btnGame = findViewById(R.id.btnGame)
        this.btnGame.setOnClickListener({
            val it = Intent(this@MainActivity, JogoDaMemoriaActivity::class.java)
            it.putExtra("MSG_IDA", "Game")
            startActivity(it)
        })


        this.btnListar = findViewById(R.id.btnListar)
        this.btnListar.setOnClickListener({
            val it = Intent(this@MainActivity, ListarProfsActivity::class.java)
            it.putExtra("MSG_IDA", "Profs")
            startActivity(it)
        })

        this.txtView = findViewById(R.id.txtView)
        this.btnSalvar = findViewById(R.id.btnSalvar)

        this.btnSalvar.setOnClickListener({

        })

    }




}

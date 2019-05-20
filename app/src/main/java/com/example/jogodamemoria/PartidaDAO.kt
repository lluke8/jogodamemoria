package com.example.jogodamemoria

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.security.AccessControlContext
class PartidaDAO {


    class PartidaDAO {
        private lateinit var banco: BancoHelper

        constructor(context: Context) {
            this.banco = BancoHelper(context)
        }

        // create
        fun insert(p: Partida) {
            val cv = ContentValues()
            cv.put("tentativa", p.tentativa)
            this.banco.writableDatabase.insert("partida", null, cv)
        }

        // all
        fun get(): ArrayList<Partida> {
            val colunas = arrayOf("id", "tentativa")
            val lista = ArrayList<Partida>()

            val c = this.banco.readableDatabase.query("partida", colunas, null, null, null, null, "tentativa")

            c.moveToFirst()

            if (c.count > 0) {
                do {
                    val id = c.getInt(c.getColumnIndex("id"))
                    val tentativa = c.getInt(c.getColumnIndex("tentativa"))
                    lista.add(Partida(id, tentativa))
                } while (c.moveToNext())
            }

            return lista
        }


        // find
        fun get(index: Int): Partida? {
            val colunas = arrayOf("id", "tentativa")
            val where = "id = ?"
            val pwhere = arrayOf(index.toString())

            val c = this.banco.readableDatabase.query("partida", colunas, where, pwhere, null, null, null)

            c.moveToFirst()

            if (c.count > 0) {
                val id = c.getInt(c.getColumnIndex("id"))
                val tentativa = c.getInt(c.getColumnIndex("tentativa"))
                return Partida(id, tentativa)
            }

            return null
        }

        // update
        fun update(p: Partida) {
            val where = "id = ?"
            val pwhere = arrayOf(p.id.toString())
            val cv = ContentValues()
            cv.put("id", p.id)
            cv.put("tentativa", p.tentativa)


            this.banco.writableDatabase.update("partida", cv, where, pwhere)
        }

        // delete
        fun delete(id: Int) {
            val where = "id = ?"
            val pwhere = arrayOf(id.toString())

            this.banco.writableDatabase.delete("partida", where, pwhere)
        }
    }
}
package com.example.jogodamemoria

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Professor (
        var nome:String,
        var compCurricular:String,
        var imageUrl:String

){




    companion object {

        fun getProfsFromFile(filename: String, context: Context): ArrayList<Professor> {
            val profList = ArrayList<Professor>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("profs.json", context)
                val json = JSONObject(jsonString)
                val profs = json.getJSONArray("profs")

                // Get Recipe objects from data
                (0 until profs.length()).mapTo(profList) {
                    Professor(profs.getJSONObject(it).getString("nome"),
                            profs.getJSONObject(it).getString("compCurricular"),
                            profs.getJSONObject(it).getString("image"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return profList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}
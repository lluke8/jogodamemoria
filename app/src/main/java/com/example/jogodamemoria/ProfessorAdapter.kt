package com.example.jogodamemoria

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class RecipeAdapter(private val context: Context,
                    private val dataSource: ArrayList<Professor>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {




        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_prof, parent, false)

        // Get title element
        val nomeTextView = rowView.findViewById(R.id.prof_list_nome) as TextView

        // Get subtitle element
        val subtitleTextView = rowView.findViewById(R.id.prof_list_subtitle) as TextView


        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.prof_list_thumbnail) as ImageView

        // 1
        val professor = getItem(position) as Professor

        // 2
        nomeTextView.text = professor.nome
        subtitleTextView.text = professor.compCurricular

        // 3
        Picasso.with(context).load(professor.img).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }
}
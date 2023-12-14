package com.riadul.advancedandroid.recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.recycle_view.model.Fruit

class RecyclerViewAdapter(private val fruitsList: List<Fruit>, val listener: (Fruit) -> Unit)  : RecyclerView.Adapter<MyViewHolder>() {

    //private val fruitsList = listOf("Apple", "Banana", "Orange", "Grapes", "Mango")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruitName = fruitsList[position]
        holder.bind(fruitName, listener)
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, listener: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener {
            listener(fruit)
        }
    }


}

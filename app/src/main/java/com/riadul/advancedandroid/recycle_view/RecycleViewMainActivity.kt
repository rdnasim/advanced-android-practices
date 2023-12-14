package com.riadul.advancedandroid.recycle_view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.recycle_view.model.Fruit

class RecycleViewMainActivity : AppCompatActivity() {

    private val fruitsList = listOf(
        Fruit(name = "Apple", supplier = "Supplier A"),
        Fruit(name = "Banana", supplier = "Supplier B"),
        Fruit(name = "Orange", supplier = "Supplier C"),
        Fruit(name = "Grapes", supplier = "Supplier D"),
        Fruit(name = "Mango", supplier = "Supplier E"),
        Fruit(name = "Pineapple", supplier = "Supplier F"),
        Fruit(name = "Watermelon", supplier = "Supplier G"),
        Fruit(name = "Strawberry", supplier = "Supplier H"),
        Fruit(name = "Papaya", supplier = "Supplier I"),
        Fruit(name = "Kiwi", supplier = "Supplier J"),
        Fruit(name = "Cherry", supplier = "Supplier K"),
        Fruit(name = "Grapefruit", supplier = "Supplier L"),
        Fruit(name = "Lemon", supplier = "Supplier M"),
        Fruit(name = "Peach", supplier = "Supplier N"),
        Fruit(name = "Apricot", supplier = "Supplier O"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(
            fruitsList
        ) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }
    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this@RecycleViewMainActivity, "Selected fruit is ${fruit.name}", Toast.LENGTH_SHORT).show()
    }
}
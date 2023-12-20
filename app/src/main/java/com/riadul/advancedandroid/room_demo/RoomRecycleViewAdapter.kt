package com.riadul.advancedandroid.room_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ListItemRoomBinding
import com.riadul.advancedandroid.room_demo.db.Subscriber

class RoomRecycleViewAdapter(
//    private val subscribers: List<Subscriber>,
    private val clickListener: (Subscriber) -> Unit,
) : RecyclerView.Adapter<RoomViewHolder>() {

    private val subscribers = ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemRoomBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_room, parent, false)
        return RoomViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscribers.size
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(subscribers[position], clickListener)
    }

    fun setList(subscribers: List<Subscriber>) {
        this.subscribers.clear()
        this.subscribers.addAll(subscribers)
    }

}

class RoomViewHolder(
    val binding: ListItemRoomBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit = {}) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email

        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }
    }
}
package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shadowarm.dataclass.ContactEntity
import com.shadowarm.roomimplementation.R


class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var mylist = emptyList<ContactEntity>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_part_design, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curentItem = mylist[position]
        holder.itemView.findViewById<TextView>(R.id.idTV).text = curentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.nameTV).text = curentItem.title.toString()
        holder.itemView.findViewById<TextView>(R.id.titleTV).text = curentItem.price.toString()
    }

    fun setData(contactEntity: List<ContactEntity>) {
        this.mylist = contactEntity
        notifyDataSetChanged()
    }

}
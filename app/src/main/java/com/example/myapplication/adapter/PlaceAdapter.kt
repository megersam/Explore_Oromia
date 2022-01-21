package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.PlaceData
import com.example.myapplication.view.NewActivity

class PlaceAdapter(
  var c:Context, var PlaceList:ArrayList<PlaceData>
) :RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>()
{
    inner class PlaceViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflater, R.layout.item_list, parent, false
        )
        return PlaceViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val newlist = PlaceList[position]
        holder.v.isPlace = PlaceList[position]


        holder.v.root.setOnClickListener{
            val img = newlist.img
            val name = newlist.name
            val info = newlist.info
            val mIntent = Intent(c, NewActivity::class.java)
            mIntent.putExtra("img", img)
            mIntent.putExtra("name", name)
            mIntent.putExtra("info", info)
            c.startActivity(mIntent)
        }

    }

    override fun getItemCount(): Int {
        return PlaceList.size
    }
}
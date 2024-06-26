package com.example.luxtrace.ui.listmaterial

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R
import com.example.luxtrace.ui.listmaterial.detailmaterial.DetailMaterial

class ListMaterialAdapter(private val listMaterial: ArrayList<Material>) : RecyclerView.Adapter<ListMaterialAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_material, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMaterial.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nMaterial, dMaterial, pMaterial) = listMaterial[position]
        holder.imgPhoto.setImageResource(pMaterial)
        holder.tvName.text = nMaterial
        holder.tvDescription.text = dMaterial

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMaterial::class.java)
            intentDetail.putExtra("key_hero", listMaterial[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}
package com.example.luxtrace.ui.processingproduct

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R
import com.example.luxtrace.ui.listmaterial.detailmaterial.DetailMaterial
import com.example.luxtrace.ui.processingproduct.detailprocessing.DetailProcessing

class ListProcessingProductAdapter(private val listProcessingProduct: ArrayList<ProcessingProduct>) : RecyclerView.Adapter<ListProcessingProductAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvStatus: TextView = itemView.findViewById(R.id.tv_item_status)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_processing_product, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listProcessingProduct.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, status, description) = listProcessingProduct[position]
        holder.tvName.text = name
        holder.tvStatus.text = status
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailProcessing::class.java)
            intentDetail.putExtra("key_hero", listProcessingProduct[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}
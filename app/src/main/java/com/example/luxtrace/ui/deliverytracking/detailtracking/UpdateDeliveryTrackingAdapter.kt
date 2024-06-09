package com.example.luxtrace.ui.deliverytracking.detailtracking

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R
import com.example.luxtrace.ui.deliverytracking.ListDeliveryTrackingAdapter

class UpdateDeliveryTrackingAdapter(private val detailTracking: ArrayList<UpdateDeliveryTracking>) : RecyclerView.Adapter<UpdateDeliveryTrackingAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tv_item_date)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvStatus: TextView = itemView.findViewById(R.id.tv_item_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_update_tracking, parent, false)
        return UpdateDeliveryTrackingAdapter.ListViewHolder(view)
    }

    override fun getItemCount(): Int = detailTracking.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (date, description, status) = detailTracking[position]
        holder.tvDate.text = date
        holder.tvDescription.text = description
        holder.tvStatus.text = status
    }
}